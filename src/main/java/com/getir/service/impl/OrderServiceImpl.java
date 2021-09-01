package com.getir.service.impl;

import com.getir.entity.Book;
import com.getir.entity.Customer;
import com.getir.entity.Order;
import com.getir.exception.EntityNotExistException;
import com.getir.exception.NewStockCannotBiggerThanOldStockException;
import com.getir.exception.OrderCountInvalidException;
import com.getir.model.dto.OrderDTO;
import com.getir.model.dto.OrderDetailDTO;
import com.getir.model.dto.OrderLightDTO;
import com.getir.model.enums.Status;
import com.getir.model.request.OrderByDateRequest;
import com.getir.model.request.OrderRequest;
import com.getir.model.response.OrderListResponse;
import com.getir.model.response.OrderResponse;
import com.getir.repository.BookRepository;
import com.getir.repository.CustomerRepository;
import com.getir.repository.OrderRepository;
import com.getir.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final BookRepository bookRepository;

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    public OrderServiceImpl(BookRepository bookRepository, CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(OrderRequest request) {

        Customer customer = customerRepository.getById(request.getCustomerID());

        List<Integer> bookIDs = new ArrayList<>();
        request.getOrders().forEach(orderDTO -> bookIDs.add(orderDTO.getBookID()));
        List<Book> books = bookRepository.findAllById(bookIDs);

        Long totalBookCount = 0L;
        Map<Integer, Integer> bookAndCountMap = new HashMap<>();
        for (OrderDetailDTO dto : request.getOrders()) {

            if(dto.getOrderCount() <= 0)
                throw new OrderCountInvalidException(String.valueOf(dto.getOrderCount()));

            totalBookCount += dto.getOrderCount();
            bookAndCountMap.put(dto.getBookID(), dto.getOrderCount());
        }

        Order order = new Order();
        order.setBookList(books);
        order.setTotalCost(calculatePrice(bookAndCountMap, books));
        order.setDateCreated(new Date());
        order.setCustomerId(request.getCustomerID());
        order.setTotalBookCount(totalBookCount);
        customer.getOrderList().add(order);

        customerRepository.save(customer);

        logger.info("Order added to customer! {}", customer);

        updateStockInformation(bookAndCountMap, books);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrder(order.toLightDTO(order));
        orderResponse.setCustomer(customer.toLightDTO(customer));

        logger.info("Order created "+ orderResponse);

        return orderResponse;
    }

    private BigDecimal calculatePrice(Map<Integer, Integer> bookAndCountMap, List<Book> books) {

        logger.info("Price calculating {}!", books);

        long totalPrice = 0L;

        for(Map.Entry<Integer, Integer> entry : bookAndCountMap.entrySet()) {
            Book book = books
                    .stream()
                    .filter(b -> b.getId() == entry.getKey())
                    .findAny()
                    .orElse(null);

            if(book != null)
                totalPrice += book.getCost().longValue() * entry.getValue();
            else
                throw new EntityNotExistException();
        }

        logger.info("Total price is: {}, books: {}", totalPrice, books);

        return new BigDecimal(totalPrice);

    }

    private void updateStockInformation(Map<Integer, Integer> bookAndCountMap, List<Book> books) {

        for(Map.Entry<Integer, Integer> entry : bookAndCountMap.entrySet()) {
            Book book = books.stream()
                    .filter(b -> b.getId() == entry.getKey())
                    .findAny().orElse(null);

            if(book != null){
                if(entry.getValue() > book.getRemainingStock())
                    throw new NewStockCannotBiggerThanOldStockException();

                book.setRemainingStock(book.getRemainingStock() - entry.getValue());
            } else {
                throw new EntityNotExistException("Book not found.");
            }

        }

        logger.info("Stocks updated ! {}", books);

    }

    public OrderResponse getOrderById(int id) {

        Customer customer = customerRepository.getCustomerByOrderListId(id);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setCustomer(customer.toLightDTO(customer));

        OrderLightDTO orderLightDTO = new OrderLightDTO();

        Order order = customer.getOrderList()
                .stream()
                .filter(o -> o.getId() == (id))
                .findFirst()
                .orElse(null);

        if(order!=null)
            orderLightDTO = order.toLightDTO(order);
        else
            throw new EntityNotExistException("There is no order!");

        orderResponse.setOrder(orderLightDTO);

        logger.info("Order response " +  orderResponse);

        return orderResponse;

    }

    public OrderListResponse getOrderBetweenDates(OrderByDateRequest request) {

        List<Order> orderList = orderRepository.getAllByDateCreatedBetween(request.getStartDate(), request.getEndDate());
        List<OrderDTO> orderDTOS = new ArrayList<>();

        orderList.forEach(order -> orderDTOS.add(order.toDTO(order)));

        logger.info("Orders between dates [{}-{}]", request.getStartDate(), request.getEndDate());

        OrderListResponse response = new OrderListResponse();
        response.setStatus(Status.SUCCESS);
        response.setOrders(orderDTOS);

        return response;
    }
}

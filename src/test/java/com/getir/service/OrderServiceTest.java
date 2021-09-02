package com.getir.service;

import com.getir.entity.Book;
import com.getir.entity.Customer;
import com.getir.entity.Order;
import com.getir.exception.EntityNotExistException;
import com.getir.model.dto.OrderDetailDTO;
import com.getir.model.request.OrderByDateRequest;
import com.getir.model.request.OrderRequest;
import com.getir.repository.BookRepository;
import com.getir.repository.CustomerRepository;
import com.getir.repository.OrderRepository;
import com.getir.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void it_should_create_order() {

        Book book = new Book();
        book.setId(1);
        book.setName("The Silmarillion");
        book.setAuthor("J. R. R. Tolkien");
        book.setCost(new BigDecimal(15));
        book.setRemainingStock(10L);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book);
        bookList.add(book);


        Mockito.when(bookRepository.findAllById(Mockito.anyCollection())).thenReturn(bookList);

        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("m");
        customer.setEmail("m@gmail.com");
        customer.setOrderList(new ArrayList<>());

        Mockito.when(customerRepository.getById(customer.getId())).thenReturn(customer);

        List<OrderDetailDTO> orders = new ArrayList<>();
        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setOrderCount(1);
        dto.setBookID(1);
        orders.add(dto);

        OrderRequest request = new OrderRequest();
        request.setCustomerID(1);
        request.setOrders(orders);

        orderService.createOrder(request);
    }

    @Test
    public void it_should_get_order_by_id(){

        Book book = new Book();
        book.setId(1);
        book.setName("The Silmarillion");
        book.setAuthor("J. R. R. Tolkien");
        book.setCost(new BigDecimal(15));
        book.setRemainingStock(10L);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book);
        bookList.add(book);

        Order order = new Order();
        order.setId(1);
        order.setDateCreated(new Date(1995, Calendar.JULY,7));
        order.setTotalCost(new BigDecimal(15));
        order.setCustomerId(1);
        order.setBookList(bookList);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        orderList.add(order);

        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("m");
        customer.setEmail("m@gmail.com");
        customer.setOrderList(orderList);

        Mockito.when(customerRepository.getCustomerByOrderListId(customer.getId())).thenReturn(customer);

        orderService.getOrderById(1);
    }

    @Test(expected = EntityNotExistException.class)
    public void it_should_get_order_by_id_and_throws_exception(){

        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("m");
        customer.setEmail("m@gmail.com");
        customer.setOrderList(new ArrayList<>());

        Mockito.when(customerRepository.getCustomerByOrderListId(customer.getId())).thenReturn(customer);

        orderService.getOrderById(1);
    }

    @Test
    public void it_should_get_order_by_date_interval(){

        OrderByDateRequest request = new OrderByDateRequest();
        request.setStartDate(new Date(1995, Calendar.JULY,7));
        request.setStartDate(new Date(2021, Calendar.JULY,7));

        Book book = new Book();
        book.setId(1);
        book.setName("The Silmarillion");
        book.setAuthor("J. R. R. Tolkien");
        book.setCost(new BigDecimal(15));
        book.setRemainingStock(10L);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book);
        bookList.add(book);

        List<Order> orderList = new ArrayList<>();

        Order order = new Order();
        order.setId(1);
        order.setDateCreated(new Date(1995, Calendar.JULY,7));
        order.setTotalCost(new BigDecimal(15));
        order.setCustomerId(1);
        order.setBookList(bookList);

        orderList.add(order);
        orderList.add(order);

        Mockito.when(orderRepository.getAllByDateCreatedBetween(request.getStartDate(),request.getEndDate()))
                .thenReturn(orderList);

        orderService.getOrderBetweenDates(request);
    }
}

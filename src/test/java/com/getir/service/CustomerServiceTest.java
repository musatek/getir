package com.getir.service;

import com.getir.entity.Book;
import com.getir.entity.Order;
import com.getir.model.request.CustomerCreateRequest;
import com.getir.model.request.CustomerParameterRequest;
import com.getir.repository.CustomerRepository;
import com.getir.repository.OrderRepository;
import com.getir.service.impl.CustomerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void it_should_save_customer() {

        CustomerCreateRequest request = new CustomerCreateRequest();
        request.setUsername("name");
        request.setEmail("m@gmail.com");
        request.setOrderList(new ArrayList<>());

        customerService.createCustomer(request);

    }


    @Test
    public void it_should_get_customer_orders() {

        CustomerParameterRequest request = new CustomerParameterRequest();
        request.setId(1);
        request.setPage(0);
        request.setSize(3);

        Book book = new Book();
        book.setId(1);
        book.setName("The Silmarillion");
        book.setAuthor("J. R. R. Tolkien");
        book.setCost(new BigDecimal(15));
        book.setRemainingStock(10L);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        Order order = new Order();
        order.setId(1);
        order.setDateCreated(new Date(1995, Calendar.JULY,7));
        order.setTotalCost(new BigDecimal(15));
        order.setCustomerId(1);
        order.setBookList(bookList);

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order);
        orders.add(order);

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        Mockito.when(orderRepository.findByCustomerId(request.getId(), pageable)).thenReturn(orders);

        customerService.getCustomerOrders(request);

    }

    @Test
    public void it_should_get_customer_orders_empty() {

        CustomerParameterRequest request = new CustomerParameterRequest();
        request.setId(1);
        request.setPage(0);
        request.setSize(3);

        List<Order> orders = new ArrayList<>();

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        Mockito.when(orderRepository.findByCustomerId(request.getId(), pageable)).thenReturn(orders);

        customerService.getCustomerOrders(request);

    }
}

package com.getir.service.impl;

import com.getir.entity.Customer;
import com.getir.entity.Order;
import com.getir.exception.MailAlreadyExistException;
import com.getir.model.dto.OrderDTO;
import com.getir.model.enums.Status;
import com.getir.model.request.CustomerCreateRequest;
import com.getir.model.request.CustomerParameterRequest;
import com.getir.model.response.CustomerPageResponse;
import com.getir.model.response.CustomerResponse;
import com.getir.repository.CustomerRepository;
import com.getir.repository.OrderRepository;
import com.getir.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public CustomerResponse createCustomer(CustomerCreateRequest request) {

        validateEmail(request.getEmail());

        Customer customer = new Customer();
        customer.setUsername(request.getUsername());
        customer.setEmail(request.getEmail());
        customer.setOrderList(request.getOrderList());

        customerRepository.save(customer);

        logger.info("Customer saved! {}", customer);

        CustomerResponse response = new CustomerResponse();
        response.setStatus(Status.SUCCESS);
        response.setCustomer(customer.toDTO(customer));

        return response;
    }

    private void validateEmail(String email) {

        Customer customer = customerRepository.getCustomerByEmail(email);

        if(customer != null)
            throw new MailAlreadyExistException(email);
    }

    @Override
    public CustomerPageResponse getCustomerOrders(CustomerParameterRequest request) {

            CustomerPageResponse customerPageResponse = new CustomerPageResponse();

            Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

            List<Order> orders = orderRepository.findByCustomerId(request.getId(), pageable);

            if(orders.isEmpty()){
                customerPageResponse.setOrderDTOS(new PageImpl<>(Collections.emptyList()));
                logger.warn("Customer page is empty! {}", request);
                return customerPageResponse;
            }

            List<OrderDTO> dtoList = new ArrayList<>();

            orders.forEach(order -> dtoList.add(order.toDTO(order)));

            customerPageResponse.setOrderDTOS(new PageImpl<>(dtoList, PageRequest.of(request.getPage(), request.getSize()), customerRepository.count()));

            logger.info("Customer page is ready! {}", customerPageResponse);

            return customerPageResponse;

        }

}

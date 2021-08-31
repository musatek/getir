package com.getir.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    public void it_should_convert_to_string_properly() {

        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("musatek");
        customer.setEmail("musatek@gmail.com");
        customer.setOrderList(new ArrayList<>());

        String customerStringValue = customer.toString();

        Assertions.assertEquals(customerStringValue,"Customer{id=1, version=0, username='musatek', email='musatek@gmail.com', orderList=[]}");

    }
}
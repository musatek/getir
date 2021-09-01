package com.getir.model.dto;

import com.getir.entity.Customer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class CustomerDTOTest {

    @Test
    public void it_should_convert_to_string_properly() {

        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("musatek");
        customer.setEmail("musatek@gmail.com");
        customer.setOrderList(new ArrayList<>());

        CustomerDTO dto = customer.toDTO(customer);
        String customerStringValue = dto.toString();

        Assertions.assertEquals(customerStringValue,"CustomerDTO{id=1, username='musatek', email='musatek@gmail.com', orderList=[]}");
    }
}

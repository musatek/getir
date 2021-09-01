package com.getir.model.response;

import com.getir.entity.Customer;
import com.getir.model.dto.CustomerDTO;
import com.getir.model.enums.Status;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerResponseTest {

    @Test
    public void it_should_convert_to_string_properly() {

        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("musatek");
        customer.setEmail("musatek@gmail.com");
        customer.setOrderList(new ArrayList<>());

        CustomerDTO dto = customer.toDTO(customer);

        CustomerResponse response = new CustomerResponse();
        response.setCustomer(dto);
        response.setStatus(Status.SUCCESS);

        String responseStringValue = response.toString();

        assertThat(responseStringValue).isEqualTo("CustomerResponse(customer=CustomerDTO{id=1, username='musatek', email='musatek@gmail.com', orderList=[]}, status=SUCCESS)");
    }
}

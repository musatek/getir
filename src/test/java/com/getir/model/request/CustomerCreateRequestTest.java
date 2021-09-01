package com.getir.model.request;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerCreateRequestTest {

    @Test
    public void it_should_convert_to_string_properly() {

        CustomerCreateRequest request = new CustomerCreateRequest();
        request.setEmail("email");
        request.setUsername("name");
        request.setOrderList(new ArrayList<>());

        String requestStringValue = request.toString();

        assertThat(requestStringValue).isEqualTo("CustomerCreateRequest(username=name, email=email, orderList=[])");
    }
}

package com.getir.model.request;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderRequestTest {

    @Test
    public void it_should_convert_to_string_properly() {

        OrderRequest request = new OrderRequest();
        request.setOrders(new ArrayList<>());
        request.setCustomerID(1);

        String requestStringValue = request.toString();

        assertThat(requestStringValue).isEqualTo("OrderRequest(customerID=1, orders=[])");
    }
}
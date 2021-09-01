package com.getir.model.response;

import com.getir.model.enums.Status;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderListResponseTest {

    @Test
    public void it_should_convert_to_string_properly() {

        OrderListResponse response = new OrderListResponse();
        response.setStatus(Status.SUCCESS);
        response.setOrders(new ArrayList<>());

        String responseStringValue = response.toString();

        assertThat(responseStringValue).isEqualTo("OrderListResponse(orders=[], status=SUCCESS)");
    }
}

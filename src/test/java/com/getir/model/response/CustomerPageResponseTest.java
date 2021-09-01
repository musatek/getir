package com.getir.model.response;

import org.junit.Test;
import org.springframework.data.domain.PageImpl;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerPageResponseTest {

    @Test
    public void it_should_convert_to_string_properly() {

        CustomerPageResponse response = new CustomerPageResponse();
        response.setOrderDTOS(new PageImpl<>(Collections.emptyList()));

        String responseStringValue = response.toString();

        assertThat(responseStringValue).isEqualTo("CustomerPageResponse(orderDTOS=Page 1 of 1 containing UNKNOWN instances)");
    }
}

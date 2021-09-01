package com.getir.model.request;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerParameterRequestTest {

    @Test
    public void it_should_convert_to_string_properly() {

        CustomerParameterRequest request = new CustomerParameterRequest();
        request.setId(1);
        request.setPage(1);
        request.setSize(1);

        String requestStringValue = request.toString();

        assertThat(requestStringValue).isEqualTo("CustomerParameterRequest(id=1, page=1, size=1)");
    }
}
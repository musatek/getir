package com.getir.model.request;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class BookCreateRequestTest {

    @Test
    public void it_should_convert_to_string_properly() {

        BookCreateRequest request = new BookCreateRequest();
        request.setName("name");
        request.setAuthor("author");
        request.setCost(new BigDecimal(1));
        request.setRemainingStock(1L);

        String requestStringValue = request.toString();

        assertThat(requestStringValue).isEqualTo("BookCreateRequest{name='name', author='author', cost=1, remainingStock=1}");

    }
}

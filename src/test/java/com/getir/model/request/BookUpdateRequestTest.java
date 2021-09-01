package com.getir.model.request;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class BookUpdateRequestTest {

    @Test
    public void it_should_convert_to_string_properly() {

        BookUpdateRequest request = new BookUpdateRequest();
        request.setId(1);
        request.setName("name");
        request.setAuthor("writer");
        request.setCost(new BigDecimal(1));
        request.setRemainingStock(1L);

        String requestStringValue = request.toString();

        assertThat(requestStringValue).isEqualTo("BookUpdateRequest{id=1, name='name', author='writer', cost=1, remainingStock=1}");

    }
}

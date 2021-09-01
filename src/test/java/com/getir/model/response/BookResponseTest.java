package com.getir.model.response;


import com.getir.model.dto.BookDTO;
import com.getir.model.enums.Status;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BookResponseTest {

    @Test
    public void it_should_convert_to_string_properly() {

        BookResponse response = new BookResponse();
        response.setBook(new BookDTO());
        response.setStatus(Status.SUCCESS);

        String responseStringValue = response.toString();

        assertThat(responseStringValue).isEqualTo("BookResponse(book=BookDTO(id=0, name=null, author=null, cost=null, remainingStock=null), status=SUCCESS)");
    }

}
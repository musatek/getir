package com.getir.model.dto;

import com.getir.entity.Book;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class BookLightDTOTest {

    @Test
    public void it_should_convert_to_string_properly() {

        Book book = new Book();
        book.setId(1);
        book.setName("1984");
        book.setAuthor("George Orwell");
        book.setCost(new BigDecimal(1));
        book.setRemainingStock(1L);

        BookLightDTO dto = book.toLightDTO(book);

        String bookStringValue = dto.toString();

        Assertions.assertEquals(bookStringValue,"BookLightDTO(name=1984, author=George Orwell, cost=1)");
    }
}

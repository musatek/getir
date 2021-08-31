package com.getir.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class BookTest {

    @Test
    public void it_should_convert_to_string_properly() {

        Book book = new Book();
        book.setId(1);
        book.setName("1984");
        book.setAuthor("George Orwell");
        book.setCost(new BigDecimal(1));
        book.setRemainingStock(1L);

        String bookStringValue = book.toString();

        Assertions.assertEquals(bookStringValue,"Book{id=1, version=0, name='1984', author='George Orwell', cost=1, remainingStock=1}");
    }

}
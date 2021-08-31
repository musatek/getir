package com.getir.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

class OrderTest {

    @Test
    public void it_should_convert_to_string_properly() {

        Book book = new Book();
        book.setId(1);
        book.setName("1984");
        book.setAuthor("George Orwell");
        book.setCost(new BigDecimal(1));
        book.setRemainingStock(1L);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        Order order = new Order();
        order.setId(1);
        order.setDateCreated(new Date(2005, Calendar.JULY,18));
        order.setTotalCost(new BigDecimal(15));
        order.setCustomerId(1);
        order.setBookList(bookList);

        String orderStringValue = order.toString();

        System.out.println(orderStringValue);

        Assertions.assertEquals(orderStringValue, "Order{id=1, version=0, customerId=1, totalCost=15, dateCreated=Tue Jul 18 00:00:00 TRT 3905, bookList=[Book{id=1, version=0, name='1984', author='George Orwell', cost=1, remainingStock=1}], totalBookCount=null}");
    }
}
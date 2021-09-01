package com.getir.model.dto;

import com.getir.entity.Book;
import com.getir.entity.Order;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderLightDTOTest {

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
        order.setId(11);
        order.setDateCreated(new Date(1995, Calendar.JULY,7));
        order.setTotalCost(new BigDecimal(15));
        order.setCustomerId(11);
        order.setBookList(bookList);

        OrderLightDTO dto = order.toLightDTO(order);
        String orderStringValue = dto.toString();

        Assertions.assertEquals(orderStringValue,"OrderLightDTO(totalCost=15, dateCreated=Sun Jul 07 00:00:00 TRT 3895, bookList=[BookLightDTO(name=1984, author=George Orwell, cost=1)])");
    }
}

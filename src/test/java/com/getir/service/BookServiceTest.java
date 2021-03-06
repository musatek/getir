package com.getir.service;

import com.getir.model.request.BookCreateRequest;
import com.getir.model.request.BookUpdateRequest;
import com.getir.model.response.BookResponse;
import com.getir.repository.BookRepository;
import com.getir.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
class BookServiceTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void it_should_save_book(){

        BookCreateRequest request = new BookCreateRequest();

        request.setAuthor("Musa");
        request.setName("Musa");
        request.setRemainingStock(123L);
        request.setCost(new BigDecimal(123));

        BookResponse bookResponse = bookService.createBook(request);

        Assertions.assertEquals(new BookResponse(),bookResponse);

    }

    @Test
    public void it_should_update_book(){

        BookUpdateRequest request = new BookUpdateRequest();

        request.setId(1);
        request.setAuthor("Musa");
        request.setName("Musa");
        request.setRemainingStock(123L);
        request.setCost(new BigDecimal(123));

        BookResponse bookResponse = bookService.updateBook(request);

        Assertions.assertEquals(new BookResponse(),bookResponse);

    }

}
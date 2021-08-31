package com.getir.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.getir.model.request.BookCreateRequest;
import com.getir.model.request.BookUpdateRequest;
import com.getir.service.BookService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void it_should_invoke_api_book_create_endpoint() throws Exception {

        BookCreateRequest request = new BookCreateRequest();

        request.setAuthor("Musa");
        request.setName("Musa");
        request.setRemainingStock(123L);
        request.setCost(new BigDecimal(123));

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectWriter.writeValueAsString(request);

        mockMvc.perform(post("/api/v1/book").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    void it_should_invoke_api_book_update_endpoint() throws Exception {

        BookUpdateRequest request = new BookUpdateRequest();

        request.setId(1);
        request.setAuthor("Musa");
        request.setName("Musa");
        request.setRemainingStock(123L);
        request.setCost(new BigDecimal(123));

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectWriter.writeValueAsString(request);

        mockMvc.perform(put("/api/v1/book").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody))
                .andExpect(status().isOk()).andReturn();

    }
}
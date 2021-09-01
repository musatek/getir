package com.getir.service;


import com.getir.model.request.BookCreateRequest;
import com.getir.model.request.BookUpdateRequest;
import com.getir.model.response.BookResponse;

public interface BookService {

    BookResponse createBook(BookCreateRequest request);

    BookResponse updateBook(BookUpdateRequest request);

}

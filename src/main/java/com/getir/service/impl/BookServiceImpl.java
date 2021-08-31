package com.getir.service.impl;

import com.getir.entity.Book;
import com.getir.exception.EntityNotExistException;
import com.getir.model.enums.Status;
import com.getir.model.request.BookCreateRequest;
import com.getir.model.request.BookUpdateRequest;
import com.getir.model.response.BookResponse;
import com.getir.repository.BookRepository;
import com.getir.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final Logger logger = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse createBook(BookCreateRequest request) {

        Book book = new Book();
        book.setName(request.getName());
        book.setAuthor(request.getAuthor());
        book.setCost(request.getCost());
        book.setRemainingStock(request.getRemainingStock());

        bookRepository.save(book);

        logger.info("Book saved successfully! {}", book);

        BookResponse response = new BookResponse();
        response.setStatus(Status.SUCCESS);
        response.setBook(book.toDTO(book));

        return response;

    }

    @Override
    public BookResponse updateBook(BookUpdateRequest request) {
        Book book = bookRepository.findById(request.getId())
                .orElseThrow(() -> new EntityNotExistException(String.valueOf(request.getId())));

        book.setName(request.getName());
        book.setAuthor(request.getAuthor());
        book.setCost(request.getCost());
        book.setRemainingStock(request.getRemainingStock());

        bookRepository.save(book);

        logger.info("Book updated successfully! {}", book);

        BookResponse response = new BookResponse();
        response.setStatus(Status.SUCCESS);
        response.setBook(book.toDTO(book));

        return response;
    }
}

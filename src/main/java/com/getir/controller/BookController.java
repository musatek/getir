package com.getir.controller;

import com.getir.constants.ApiEndPoints;
import com.getir.model.request.BookCreateRequest;
import com.getir.model.request.BookUpdateRequest;
import com.getir.model.response.BookResponse;
import com.getir.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = ApiEndPoints.BOOK_API, produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Api
@SwaggerDefinition(tags = {
        @Tag(name = "book-api", description = "Book Api")
})
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Create Book", notes = "Create Book")
    public BookResponse createBook(@Valid @RequestBody BookCreateRequest request){
        logger.info("Creating book started for request {}", request);
        return bookService.createBook(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update Book", notes = "Update Book")
    public BookResponse updateBook(@Valid @RequestBody BookUpdateRequest request){
        logger.info("Updating book started for request: {}", request);
        return bookService.updateBook(request);
    }

}

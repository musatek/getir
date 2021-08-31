package com.getir.model.response;

import com.getir.model.dto.BookDTO;
import com.getir.model.enums.Status;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookResponse {

    private BookDTO book;

    private Status status;
}

package com.getir.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class BookLightDTO {

    private String name;
    private String author;
    private BigDecimal cost;

}

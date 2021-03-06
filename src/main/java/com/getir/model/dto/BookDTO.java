package com.getir.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookDTO {

    private int id;

    private String name;

    private String author;

    private Double cost;

    private Long remainingStock;

}

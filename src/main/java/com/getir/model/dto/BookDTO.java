package com.getir.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

    private int id;

    private String name;

    private String author;

    private Double cost;

    private Long remainingStock;

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", cost=" + cost +
                ", remainingStock=" + remainingStock +
                '}';
    }

}

package com.getir.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class OrderLightDTO {

    private BigDecimal totalCost;
    private Date dateCreated;
    private List<BookLightDTO> bookList;

}

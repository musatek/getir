package com.getir.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private int id;
    private int customerId;
    private BigDecimal totalCost;
    private Date dateCreated;
    private List<BookDTO> bookList;
    private Long totalBookCount;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", totalCost=" + totalCost +
                ", dateCreated=" + dateCreated +
                ", bookList=" + bookList +
                ", totalBookCount=" + totalBookCount +
                '}';
    }
}

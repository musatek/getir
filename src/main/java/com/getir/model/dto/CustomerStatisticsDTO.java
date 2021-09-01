package com.getir.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Month;

@Getter
@Setter
@ToString
public class CustomerStatisticsDTO {

    private Month month;
    private int totalOrderCount;
    private int totalBookCount;
    private BigDecimal totalPurchasedAmount;

}

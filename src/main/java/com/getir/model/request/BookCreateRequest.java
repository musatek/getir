package com.getir.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class BookCreateRequest {

    @NotEmpty(message = "Book name can not be empty.")
    private String name;

    @NotEmpty(message = "Author name can not be empty.")
    private String author;

    @DecimalMin(value = "0.0", inclusive = false, message = "Cost can not be less than zero.")
    private BigDecimal cost;

    @NotNull(message = "Stock can not be null.")
    private Long remainingStock;

    @Override
    public String toString() {
        return "BookCreateRequest{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", cost=" + cost +
                ", remainingStock=" + remainingStock +
                '}';
    }
}

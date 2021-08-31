package com.getir.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class BookUpdateRequest {

    @NotNull(message = "ID can not be null.")
    private int id;

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
        return "BookUpdateRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", cost=" + cost +
                ", remainingStock=" + remainingStock +
                '}';
    }
}

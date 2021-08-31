package com.getir.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.getir.model.dto.BookDTO;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private int version;

    @NotEmpty(message = "Book name can not be empty.")
    private String name;

    @NotEmpty(message = "Author name can not be empty.")
    private String author;

    @DecimalMin(value = "0.0", inclusive = false, message = "Cost can not be less than zero.")
    private BigDecimal cost;

    @NotNull(message = "Stock can not be null.")
    private Long remainingStock;

    public BookDTO toDTO(Book book) {

        BookDTO dto = new BookDTO();
        dto.setId(getId());
        dto.setName(getName());
        dto.setAuthor(getAuthor());
        dto.setCost(getCost().doubleValue());
        dto.setRemainingStock(getRemainingStock());

        return dto;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", cost=" + cost +
                ", remainingStock=" + remainingStock +
                '}';
    }
}

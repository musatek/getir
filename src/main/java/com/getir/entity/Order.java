package com.getir.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOK_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private int version;

    private int customerId;

    @DecimalMin(value = "0.0", inclusive = false, message = "Cost can not be less than zero.")
    private BigDecimal totalCost;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @NotEmpty(message = "Order must have more than one book")
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Book> bookList;

    private Long totalBookCount;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", version=" + version +
                ", customerId=" + customerId +
                ", totalCost=" + totalCost +
                ", dateCreated=" + dateCreated +
                ", bookList=" + bookList +
                ", totalBookCount=" + totalBookCount +
                '}';
    }
}

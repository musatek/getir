package com.getir.entity;

import com.getir.model.dto.BookDTO;
import com.getir.model.dto.BookLightDTO;
import com.getir.model.dto.OrderDTO;
import com.getir.model.dto.OrderLightDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.ArrayList;
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

    public OrderDTO toDTO(Order order) {

        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setTotalCost(order.getTotalCost());
        dto.setDateCreated(order.getDateCreated());
        dto.setCustomerId(order.getCustomerId());
        dto.setTotalBookCount(order.getTotalBookCount());

        List<BookDTO> bookDTOS = new ArrayList<>();
        order.getBookList().forEach(book -> bookDTOS.add(book.toDTO(book)));

        dto.setBookList(bookDTOS);

        return dto;
    }

    public OrderLightDTO toLightDTO(Order order) {

        OrderLightDTO lightDTO = new OrderLightDTO();
        lightDTO.setDateCreated(order.getDateCreated());
        lightDTO.setTotalCost(order.getTotalCost());

        List<BookLightDTO> bookLightDTOS = new ArrayList<>();
        order.getBookList().forEach(book -> bookLightDTOS.add(book.toLightDTO(book)));

        lightDTO.setBookList(bookLightDTOS);

        return lightDTO;

    }
}

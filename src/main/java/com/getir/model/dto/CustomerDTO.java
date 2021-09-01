package com.getir.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDTO {

    private int id;
    private String username;
    private String email;
    private List<OrderDTO> orderList;

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}

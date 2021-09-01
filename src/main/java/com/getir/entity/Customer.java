package com.getir.entity;

import com.getir.model.dto.CustomerDTO;
import com.getir.model.dto.CustomerLightDTO;
import com.getir.model.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private int version;

    @NotEmpty(message = "Username can not be empty.")
    private String username;

    @Email(message = "Invalid email format")
    private String email;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Order> orderList;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", version=" + version +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", orderList=" + orderList +
                '}';
    }
    public CustomerDTO toDTO(Customer customer) {

        CustomerDTO dto = new CustomerDTO();
        dto.setId(getId());
        dto.setUsername(getUsername());
        dto.setEmail(getEmail());
        List<OrderDTO> orderDTOS = new ArrayList<>();

        if(Objects.nonNull(getOrderList()))
            getOrderList().forEach(order -> orderDTOS.add(order.toDTO(order)));

        dto.setOrderList(orderDTOS);

        return dto;
    }

    public CustomerLightDTO toLightDTO(Customer customer) {

        CustomerLightDTO lightDTO = new CustomerLightDTO();
        lightDTO.setUsername(getUsername());
        lightDTO.setEmail(getEmail());

        return lightDTO;
    }
}

package com.getir.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

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
}

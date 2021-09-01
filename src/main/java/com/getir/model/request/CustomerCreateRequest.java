package com.getir.model.request;

import com.getir.entity.Order;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@ToString
public class CustomerCreateRequest {

    @NotNull(message = "Username can not be null.")
    @Size(min = 3, max = 16, message = "Username must have min 3 and max 16 character.")
    private String username;

    @Email(message = "Invalid email format")
    private String email;

    private List<Order> orderList;

}

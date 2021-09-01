package com.getir.model.response;

import com.getir.model.dto.CustomerDTO;
import com.getir.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerResponse {

    private CustomerDTO customer;
    private Status status;

}

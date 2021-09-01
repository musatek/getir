package com.getir.model.response;

import com.getir.model.dto.OrderDTO;
import com.getir.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderListResponse {

    private List<OrderDTO> orders;
    private Status status;


}

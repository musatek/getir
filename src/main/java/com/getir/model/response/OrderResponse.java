package com.getir.model.response;

import com.getir.model.dto.CustomerLightDTO;
import com.getir.model.dto.OrderLightDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderResponse {

    private CustomerLightDTO customer;
    private OrderLightDTO order;

}

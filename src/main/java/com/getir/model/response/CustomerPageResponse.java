package com.getir.model.response;

import com.getir.model.dto.OrderDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

@Getter
@Setter
@ToString
public class CustomerPageResponse {

    private Page<OrderDTO> orderDTOS;
}

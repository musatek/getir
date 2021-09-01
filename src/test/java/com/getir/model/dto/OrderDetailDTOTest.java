package com.getir.model.dto;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class OrderDetailDTOTest {

    @Test
    public void it_should_convert_to_string_properly() {

        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setBookID(1);
        dto.setOrderCount(2);

        String dtoStringValue = dto.toString();

        Assertions.assertEquals(dtoStringValue,"OrderDetailDTO(bookID=1, orderCount=2)");
    }
}

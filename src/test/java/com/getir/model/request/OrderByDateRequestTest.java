package com.getir.model.request;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderByDateRequestTest {


    @Test
    public void it_should_convert_to_string_properly() {

        OrderByDateRequest request = new OrderByDateRequest();
        request.setEndDate(new Date(1995, Calendar.JULY,7));
        request.setStartDate(new Date(1995, Calendar.JULY,7));

        String requestStringValue = request.toString();

        assertThat(requestStringValue).isEqualTo("OrderByDateRequest(startDate=Sun Jul 07 00:00:00 TRT 3895, endDate=Sun Jul 07 00:00:00 TRT 3895)");
    }

}
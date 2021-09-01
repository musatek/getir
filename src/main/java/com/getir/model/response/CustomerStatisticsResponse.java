package com.getir.model.response;

import com.getir.model.dto.CustomerStatisticsDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CustomerStatisticsResponse {

    List<CustomerStatisticsDTO> customerStatistics;

}

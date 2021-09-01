package com.getir.service;

import com.getir.model.response.CustomerStatisticsResponse;

public interface StatisticsService {

    CustomerStatisticsResponse getCustomerStatistics(int id);
}

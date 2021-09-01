package com.getir.service.impl;

import com.getir.entity.Order;
import com.getir.model.dto.CustomerStatisticsDTO;
import com.getir.model.response.CustomerStatisticsResponse;
import com.getir.repository.OrderRepository;
import com.getir.service.CustomerService;
import com.getir.service.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService {
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final OrderRepository orderRepository;

    public StatisticsServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public CustomerStatisticsResponse getCustomerStatistics(int id) {

        CustomerStatisticsResponse response = new CustomerStatisticsResponse();
        List<CustomerStatisticsDTO> statisticList = new ArrayList<>();

        List<Order> orderList = orderRepository.findByCustomerId(id);

        Map<Month, List<Order>> orderMap = orderList.stream()
                .collect(groupingBy(order -> {
                    LocalDate localDate = order.getDateCreated().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    return localDate.getMonth();
                }));

        orderMap.forEach((key, orders) -> {
            CustomerStatisticsDTO dto = new CustomerStatisticsDTO();
            dto.setMonth(key);
            dto.setTotalOrderCount(orders.size());
            dto.setTotalBookCount(orders.stream().mapToInt(order -> Math.toIntExact(order.getTotalBookCount())).sum());
            BigDecimal totalAmount = BigDecimal.ZERO;
            for (Order o : orders) {
                totalAmount = totalAmount.add(BigDecimal.valueOf(o.getTotalCost().doubleValue()));
            }
            dto.setTotalPurchasedAmount(totalAmount);
            statisticList.add(dto);
        });

        response.setCustomerStatistics(statisticList);

        logger.info("Statistics are ready for customer: {}", response);

        return response;
    }
}

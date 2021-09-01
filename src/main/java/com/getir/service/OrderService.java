package com.getir.service;

import com.getir.model.request.OrderByDateRequest;
import com.getir.model.request.OrderRequest;
import com.getir.model.response.OrderListResponse;
import com.getir.model.response.OrderResponse;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);

    OrderResponse getOrderById(int id);

    OrderListResponse getOrderBetweenDates(OrderByDateRequest request);
}

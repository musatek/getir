package com.getir.controller;

import com.getir.constants.ApiEndPoints;
import com.getir.model.request.OrderByDateRequest;
import com.getir.model.request.OrderRequest;
import com.getir.model.response.OrderListResponse;
import com.getir.model.response.OrderResponse;
import com.getir.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = ApiEndPoints.ORDER_API, produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Api
@SwaggerDefinition(tags = {
        @Tag(name = "order-api", description = "Order Api")
})
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Create Order", notes = "Create Order")
    public OrderResponse createOrder(@Valid @RequestBody OrderRequest request){
        logger.info("Order Creating "+ request.toString());
        return orderService.createOrder(request);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Order By Id", notes = "Get Order By Id")
    public OrderResponse getOrderById(@PathVariable int id){
        logger.info("Getting Orders for id {}", id);
        return orderService.getOrderById(id);
    }

    @PostMapping(value = "/date", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Order By Date Interval", notes = "Get Order By Date Interval")
    public OrderListResponse getOrderBetweenDates(@Valid @RequestBody OrderByDateRequest request){
        logger.info("Getting Orders Between Selected Dates "+ request.toString());
        return orderService.getOrderBetweenDates(request);
    }
}

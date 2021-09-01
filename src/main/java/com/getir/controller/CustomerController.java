package com.getir.controller;

import com.getir.constants.ApiEndPoints;
import com.getir.model.request.CustomerCreateRequest;
import com.getir.model.request.CustomerParameterRequest;
import com.getir.model.response.CustomerPageResponse;
import com.getir.model.response.CustomerResponse;
import com.getir.service.CustomerService;
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
@RequestMapping(value = ApiEndPoints.CUSTOMER_API, produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Api
@SwaggerDefinition(tags = {
        @Tag(name = "customer-api", description = "Customer Api")
})
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Create Customer", notes = "Create Customer")
    public CustomerResponse createCustomer(@Valid @RequestBody CustomerCreateRequest request){
        logger.info("Customer Creating "+ request.toString());
        return customerService.createCustomer(request);
    }

    @PostMapping(value = "/order")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Customer Orders", notes = "Get Customer Orders")
    public CustomerPageResponse getCustomerOrders(@Valid @RequestBody CustomerParameterRequest request){
        logger.info("Getting Customer Orders "+ request.toString());
        return customerService.getCustomerOrders(request);
    }

}

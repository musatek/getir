package com.getir.service;

import com.getir.model.request.CustomerCreateRequest;
import com.getir.model.request.CustomerParameterRequest;
import com.getir.model.response.CustomerPageResponse;
import com.getir.model.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerCreateRequest request);

    CustomerPageResponse getCustomerOrders( CustomerParameterRequest request);

}

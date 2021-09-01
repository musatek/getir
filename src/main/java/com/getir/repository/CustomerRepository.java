package com.getir.repository;

import com.getir.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer getCustomerByOrderListId(int id);

    Customer getCustomerByEmail(String email);

}

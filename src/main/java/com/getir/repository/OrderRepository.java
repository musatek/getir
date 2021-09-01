package com.getir.repository;


import com.getir.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByCustomerId(int id, Pageable pageable);

    List<Order> findByCustomerId(int id);

    List<Order> getAllByDateCreatedBetween(Date startDate, Date endDate);
}

package com.a99.repository;

import com.a99.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Custom query to find orders by user ID
    List<Order> findByUserId(Long userId);
}

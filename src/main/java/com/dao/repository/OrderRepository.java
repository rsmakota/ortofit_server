package com.dao.repository;

import com.dao.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Integer countAllByProcessed(Boolean processed);
}

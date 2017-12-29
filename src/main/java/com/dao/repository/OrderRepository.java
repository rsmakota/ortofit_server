package com.dao.repository;

import com.dao.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Integer countAllByProcessed(Boolean processed);
    List<Order> findByProcessedOrderByCreatedAsc(Boolean processed, Pageable limit);
}

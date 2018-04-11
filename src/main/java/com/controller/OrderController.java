package com.controller;

import com.dao.model.Order;
import com.dao.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-17
 * Copyright  "Commercegate LTD"
 */
@RestController
@RequestMapping(value = "/api/order")
public class OrderController {
    @Autowired
    private OrderRepository repository;

    @GetMapping(value = "/")
    public List<Order> getAll(@RequestParam(value = "limit") Integer limit) {
        Pageable limitP = new PageRequest(0, limit);
        return repository.findByProcessedOrderByCreatedAsc(false, limitP);
    }

    @GetMapping(value = "/process/{id}")
    public void process(@PathVariable(value = "id") Integer id) {
        Order order = repository.findOne(id);
        if (order == null) {
            return;
        }
        order.setProcessed(true);
        repository.save(order);
    }
}

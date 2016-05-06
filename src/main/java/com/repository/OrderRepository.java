package com.repository;

import com.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "order", path = "order")
public interface OrderRepository extends CrudRepository<Order, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}

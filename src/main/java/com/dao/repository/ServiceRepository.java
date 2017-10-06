package com.dao.repository;

import com.dao.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
    Service findById(Integer id);
}

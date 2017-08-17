package com.dao.repository;

import com.dao.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}

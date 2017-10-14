package com.dao.repository;

import com.dao.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByClientId(Integer id);
}

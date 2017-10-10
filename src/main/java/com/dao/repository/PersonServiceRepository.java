package com.dao.repository;

import com.dao.model.Person;
import com.dao.model.PersonService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonServiceRepository extends JpaRepository<PersonService, Integer> {
    List<PersonService> findByAppointmentId(Integer id);
    List<PersonService> findByPerson(Person person);
}
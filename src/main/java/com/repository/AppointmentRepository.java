package com.repository;

import com.model.Appointment;
import com.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "appointment", path = "appointment")
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}

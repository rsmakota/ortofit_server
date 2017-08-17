package com.dao.repository;

import com.dao.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
}

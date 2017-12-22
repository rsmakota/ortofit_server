package com.dao.repository;

import com.dao.model.Appointment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
//    List<Country> findByLastName(@Param("name") String name);
    Appointment findFirstByClientIdAndStateOrderByIdDesc(Integer clientId, Integer status);
    Integer countAppointmentByOfficeIdAndDateTimeBetweenAndState(Integer clientDirectionId, Date from, Date to, Integer state);
}

package com.dao.repository;

import com.dao.model.AppRemind;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;


@Repository
public interface AppRemindRepository extends JpaRepository<AppRemind, Integer> {
    List<AppRemind> findByAppointmentId(Integer id);
    List<AppRemind> findByAppointmentIdAndPersonId(Integer appId, Integer personId);
    Integer countAllByProcessed(Boolean processed);
    List<AppRemind> findByProcessedFalseAndDateTimeBefore(Timestamp dateTime, Pageable limit);
}

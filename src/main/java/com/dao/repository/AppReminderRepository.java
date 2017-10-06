package com.dao.repository;

import com.dao.model.AppReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AppReminderRepository extends JpaRepository<AppReminder, Integer> {
    List<AppReminder> findByAppointmentId(Integer id);
}

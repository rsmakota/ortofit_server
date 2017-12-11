package com.dao.repository;

import com.dao.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-12-11
 * Copyright  "Commercegate LTD"
 */
public interface StaffScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByOfficeIdAndUserIdAndStartDateAfterAndEndDateBefore(Integer officeId, Integer userId, Timestamp startDate, Timestamp endDate);
    List<Schedule> findByOfficeIdAndStartDateAfterAndEndDateBefore(Integer officeId, Timestamp startDate, Timestamp endDate);
}

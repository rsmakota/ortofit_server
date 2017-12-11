package com.dao.service;

import com.dao.model.Schedule;
import com.dao.repository.StaffScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-12-11
 * Copyright  "Commercegate LTD"
 */
@Service
public class StaffScheduleService {
    @Autowired
    StaffScheduleRepository repository;

    public List<Schedule> findByRange(Timestamp from, Timestamp to, Integer officeId, Integer userId) {
        if (userId != null) {
            return repository.findByOfficeIdAndUserIdAndStartDateAfterAndEndDateBefore(officeId, userId, from, to);
        }

        return repository.findByOfficeIdAndStartDateAfterAndEndDateBefore(officeId, from, to);
    }
}

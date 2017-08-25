package com.dao.service;

import com.dao.model.Appointment;
import com.dao.model.CalendarBackgroudEvent;
import com.dao.model.CalendarEvent;
import com.dao.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-11
 * Copyright  "Commercegate LTD"
 */
@Service
public class ScheduleService implements IScheduleService {
    @Autowired
    private ScheduleRepository repository;

    @Override
    public List<CalendarEvent> findEvents(Timestamp from, Timestamp to, Integer officeId, Integer doctorId) {
        return repository.find(from, to, officeId, doctorId);
    }

    @Override
    public List<CalendarBackgroudEvent> findBackgroundEvents(Timestamp from, Timestamp to, Integer officeId, Integer doctorId) {
        return repository.findBackground(from, to, officeId, doctorId);
    }

}

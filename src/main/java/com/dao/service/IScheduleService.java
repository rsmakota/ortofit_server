package com.dao.service;

import com.dao.model.CalendarBackgroudEvent;
import com.dao.model.CalendarEvent;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-11
 * Copyright  "Commercegate LTD"
 */
public interface IScheduleService {
    public List<CalendarEvent> findEvents(Timestamp from, Timestamp to, Integer officeId, Integer doctorId);
    public List<CalendarBackgroudEvent> findBackgroundEvents(Timestamp from, Timestamp to, Integer officeId, Integer doctorId);
}

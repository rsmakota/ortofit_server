package com.dao.mapper;

import com.dao.model.CalendarBackgroudEvent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-25
 * Copyright  "Commercegate LTD"
 */
public class CalendarBackgroundEventMapper implements RowMapper<CalendarBackgroudEvent> {
    @Override
    public CalendarBackgroudEvent mapRow(ResultSet resultSet, int i) throws SQLException {
        CalendarBackgroudEvent event = new CalendarBackgroudEvent();
        event.setStart(resultSet.getString("start"));
        event.setEnd(resultSet.getString("end"));

        return event;
    }
}

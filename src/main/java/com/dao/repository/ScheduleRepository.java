package com.dao.repository;

import com.dao.mapper.CalendarEventMapper;
import com.dao.model.CalendarEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-11
 * Copyright  "Commercegate LTD"
 */
@Repository
public class ScheduleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CalendarEvent> find(Timestamp from, Timestamp to, Integer officeId, Integer personId)
    {
//        String dateFrom = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(from);
//        String dateTo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(to);
        String sql = "" +
                "SELECT a.id, a.date_time AS start, a.date_time + (a.duration || 'minutes') :: INTERVAL AS \"end\"," +
                "  s.short as title, s.color as backgroundColor, s.color as borderColor , a.bold, a.description, a.state, " +
                "(SELECT r.name " +
                "   FROM appointment_reasons ar " +
                "     JOIN reasons r ON r.id = ar.reason_id" +
                "   WHERE ar.appointment_id = a.id ORDER BY ar.created DESC LIMIT 1  ) as reason " +
                " FROM appointments a" +
                "  JOIN services s ON s.id = a.service_id" +
                " WHERE " +
                "  a.date_time > ? AND" +
                "  a.date_time < ? AND" +
                "  a.office_id = ? ";
        return jdbcTemplate.query(sql, new Object[] {from, to, officeId}, new CalendarEventMapper());
    }
}

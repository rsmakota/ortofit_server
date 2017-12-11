package com.dao.repository;

import com.response.mapper.CalendarBackgroundEventMapper;
import com.response.mapper.CalendarEventMapper;
import com.response.model.CalendarBackgroudEvent;
import com.response.model.CalendarEvent;
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

    public List<CalendarEvent> find(Timestamp from, Timestamp to, Integer officeId, Integer doctorId)
    {
        String whereUser = "" ;
        if (null != doctorId) {
            whereUser = "  a.user_id = " + doctorId.toString() + " AND ";
        }
        String sql = "" +
                "SELECT a.phone_confirm as phone, a.id, a.date_time AS start, a.date_time + (a.duration || 'minutes') :: INTERVAL AS \"end\"," +
                "  s.short as title, s.color as backgroundColor, s.color as borderColor , a.bold, a.description, a.state, " +
                "(SELECT r.name " +
                "   FROM appointment_reasons ar " +
                "     JOIN reasons r ON r.id = ar.reason_id" +
                "   WHERE ar.appointment_id = a.id ORDER BY ar.created DESC LIMIT 1  ) as reason " +
                " FROM appointments a" +
                "  JOIN services s ON s.id = a.service_id" +
                " WHERE " +
                whereUser +
                "  a.date_time > ? AND" +
                "  a.date_time < ? AND" +
                "  a.office_id = ? ";

        return jdbcTemplate.query(sql, new Object[] {from, to, officeId}, new CalendarEventMapper());
    }

    public List<CalendarBackgroudEvent> findBackground(Timestamp from, Timestamp to, Integer officeId, Integer doctorId) {
        String whereUser = "" ;
        if (null != doctorId) {
            whereUser = "  s.user_id = " + doctorId.toString() + " AND ";
        }

        String sql = "SELECT s.start_date as start, s.end_date as \"end\" " +
                "FROM schedule s WHERE " +
                whereUser +
                "  s.start_date > ? AND" +
                "  s.end_date < ? AND" +
                " s.office_id = ?";

        return jdbcTemplate.query(sql, new Object[] {from, to, officeId}, new CalendarBackgroundEventMapper());
    }
}

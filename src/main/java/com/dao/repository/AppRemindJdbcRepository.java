package com.dao.repository;

import com.dao.mapper.AppRemindReportMapper;
import com.dao.report.AppRemindReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-12-22
 * Copyright  "Commercegate LTD"
 */
@Repository
public class AppRemindJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<AppRemindReport> findAllActive(String msisdn, Integer limit, Integer offset) {
        String subSql = (null != msisdn) ? " AND c.msisdn LIKE '%"+msisdn+"%' " : "";
        String sql = "SELECT" +
                "  ar.id," +
                "  ar.date_time as dateTime," +
                "  ar.appointment_id as appointmentId," +
                "  ar.processed," +
                "  ar.description," +
                "  ar.person_id as personId," +
                "  a.date_time as appDateTime," +
                "  c.id as clientId," +
                "  c.msisdn," +
                "  a.user_id as doctorId, "+
                "  a.office_id as officeId, "+
                "  c.name as clientName," +
                "  (SELECT string_agg(DISTINCT s.name, ', ') FROM person_services ps LEFT JOIN services s ON ps.service_id = s.id WHERE ps.appointment_id = a.id ) as serviceNameList " +
                "  FROM app_reminders ar " +
                "    LEFT JOIN appointments a ON ar.appointment_id = a.id " +
                "    LEFT JOIN clients c ON a.client_id = c.id " +
                "WHERE ar.processed = false " + subSql +
                "ORDER BY ar.date_time ASC LIMIT ? OFFSET ?  ";

        return jdbcTemplate.query(sql, new Object[] {limit, offset},new AppRemindReportMapper());
    }

    public Integer countAllActive(String msisdn) {
        String subSql = (null != msisdn) ? " AND c.msisdn LIKE '%"+msisdn+"%' " : "";
        String sql = "SELECT COUNT(ar.id)" +
                "  FROM app_reminders ar " +
                "    LEFT JOIN appointments a ON ar.appointment_id = a.id " +
                "    LEFT JOIN clients c ON a.client_id = c.id " +
                "WHERE ar.processed = false " + subSql;

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}

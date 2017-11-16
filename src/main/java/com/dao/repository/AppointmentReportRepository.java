package com.dao.repository;

import com.dao.mapper.AppointmentReportMapper;
import com.dao.report.AppointmentReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-11-16
 * Copyright  "Commercegate LTD"
 */
@Repository
public class AppointmentReportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<AppointmentReport> findByClientId(Integer clientId) {
        String sql = "SELECT a.id, a.date_time, o.name as office_name,  u.name as doctor_name, s.name as service_name, a.state FROM " +
                "  appointments a " +
                "  LEFT JOIN offices o ON o.id = a.office_id " +
                "  LEFT JOIN services s ON s.id = a.service_id " +
                "  LEFT JOIN users u ON u.id = a.user_id " +
                " WHERE client_id = ?";

        return jdbcTemplate.query(sql, new Object[] {clientId}, new AppointmentReportMapper());
    }
}

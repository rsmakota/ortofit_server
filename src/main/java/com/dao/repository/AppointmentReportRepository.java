package com.dao.repository;

import com.dao.mapper.*;
import com.dao.report.*;
import com.dao.type.AppointmentState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
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

    public List<ServiceReport> findServiceReport(Integer userId, Integer officeId, Timestamp from, Timestamp to) {
        String sql = "SELECT s.alias, s.name, sum(ps.number) as total " +
                "FROM person_services ps " +
                "  LEFT JOIN appointments a ON ps.appointment_id = a.id " +
                "  LEFT JOIN services s ON ps.service_id = s.id " +
                "WHERE a.state = ? and a.date_time > ? AND a.date_time < ? " +
                "and office_id = ? and a.user_id = ? " +
                "GROUP BY ps.service_id, s.name, s.alias";

        return jdbcTemplate.query(sql, new Object[] {AppointmentState.Success.ordinal(), from, to, officeId, userId}, new ServiceReportMapper());
    }

    public List<ForwardReport> findForwardReports(Integer userId, Integer officeId, Timestamp from, Timestamp to) {
        String sql = "SELECT  a.forwarder as name, count(a.forwarder) as total, " +
                "  sum(case when a.flyer then 1 else 0 end) as flyer " +
                "FROM appointments a " +
                "WHERE a.state = ? and a.date_time > ? AND a.date_time < ? " +
                "and a.office_id = ? and a.user_id = ? and forwarder IS NOT NULL and forwarder != '' " +
                "GROUP BY forwarder";

        return jdbcTemplate.query(sql, new Object[] {AppointmentState.Success.ordinal(), from, to, officeId, userId}, new ForwardReportMapper());
    }

    public List<InsoleReport> findInsoleReports(Integer userId, Integer officeId, Timestamp from, Timestamp to) {
        String sql = "SELECT it.name, count(i.*) as total, array_agg(i.size) as sizes FROM insoles i " +
                "LEFT JOIN appointments a ON i.appointment_id = a.id " +
                "LEFT JOIN insole_types it ON i.insole_type_id = it.id " +
                "WHERE a.state = ? and a.date_time > ? AND a.date_time < ? " +
                "and a.office_id = ? and a.user_id = ? GROUP BY it.name";

        return jdbcTemplate.query(sql, new Object[] {AppointmentState.Success.ordinal(), from, to, officeId, userId}, new InsoleReportMapper());
    }

    public List<SettlementReport> findSettlementReport(Timestamp from, Timestamp to) {
        String sql = "SELECT a.forwarder as name, COUNT(a.id) as total FROM appointments a " +
                "WHERE a.state = ? and a.date_time > ? AND a.date_time < ? " +
                "and a.forwarder IS NOT NULL and a.forwarder != '' GROUP BY a.forwarder ORDER BY a.forwarder ";

        return jdbcTemplate.query(sql, new Object[] {AppointmentState.Success.ordinal(), from, to}, new SettlementReportMapper());
    }
}

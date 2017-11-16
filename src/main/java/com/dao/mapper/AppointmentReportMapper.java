package com.dao.mapper;

import com.dao.report.AppointmentReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-11-16
 * Copyright  "Commercegate LTD"
 */
public class AppointmentReportMapper implements RowMapper<AppointmentReport> {

    @Override
    public AppointmentReport mapRow(ResultSet resultSet, int i) throws SQLException {
        AppointmentReport app = new AppointmentReport();
        app.setId(resultSet.getInt("id"));
        app.setDateTime(resultSet.getTimestamp("date_time"));
        app.setDoctorName(resultSet.getString("doctor_name"));
        app.setOfficeName(resultSet.getString("office_name"));
        app.setState(resultSet.getInt("state"));

        return app;
    }
}

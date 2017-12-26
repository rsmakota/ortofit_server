package com.dao.mapper;

import com.dao.report.AppRemindReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-11-16
 * Copyright  "Commercegate LTD"
 */
public class AppRemindReportMapper implements RowMapper<AppRemindReport> {

    @Override
    public AppRemindReport mapRow(ResultSet resultSet, int i) throws SQLException {
        AppRemindReport app = new AppRemindReport();
        app.setId(resultSet.getInt("id"));
        app.setDateTime(resultSet.getTimestamp("dateTime"));
        app.setAppointmentDateTime(resultSet.getTimestamp("appDateTime"));
        app.setAppointmentId(resultSet.getInt("appointmentId"));
        app.setProcessed(resultSet.getBoolean("processed"));
        app.setDescription(resultSet.getString("description"));
        app.setPersonId(resultSet.getInt("personId"));
        app.setClientId(resultSet.getInt("clientId"));
        app.setOfficeId(resultSet.getInt("officeId"));
        app.setDoctorId(resultSet.getInt("doctorId"));
        app.setMsisdn(resultSet.getString("msisdn"));
        app.setClientName(resultSet.getString("clientName"));
        app.setServiceNameList(resultSet.getString("serviceNameList"));

        return app;
    }
}

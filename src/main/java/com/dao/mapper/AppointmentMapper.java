package com.dao.mapper;

import com.dao.model.Appointment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-11
 * Copyright  "Commercegate LTD"
 */
public class AppointmentMapper implements RowMapper<Appointment> {
    @Override
    public Appointment mapRow(ResultSet resultSet, int i) throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setId(resultSet.getInt("id"));
        appointment.setBold(resultSet.getBoolean("bold"));
        appointment.setFlyer(resultSet.getBoolean("flyer"));
        appointment.setPhoneConfirm(resultSet.getBoolean("phone_confirm"));
        appointment.setClientId(resultSet.getInt("client_id"));
        appointment.setCreated(resultSet.getTimestamp("created"));
        appointment.setDateTime(resultSet.getTimestamp("date_time"));
        appointment.setDescription(resultSet.getString("description"));
        appointment.setForwarder(resultSet.getString("forwarder"));
        appointment.setState(resultSet.getInt("state"));
        appointment.setOfficeId(resultSet.getInt("office_id"));
        appointment.setDuration(resultSet.getInt("duration"));
        appointment.setServiceId(resultSet.getInt("service_id"));

        return appointment;
    }
}

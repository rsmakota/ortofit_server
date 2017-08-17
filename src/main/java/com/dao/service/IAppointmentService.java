package com.dao.service;

import com.dao.model.Appointment;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-05-16
 * Copyright  "Commercegate LTD"
 */
public interface IAppointmentService {
    public Appointment find(Integer id);
}

package com.dao.service;

import com.dao.model.Appointment;
import com.dao.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-05-16
 * Copyright  "Commercegate LTD"
 */
@Service
@Transactional
public class AppointmentService implements IAppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public Appointment find(Integer id) {
        return repository.findOne(id);
    }

    public Appointment create(Appointment appointment) {
        return repository.save(appointment);
    }
}

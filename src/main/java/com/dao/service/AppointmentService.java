package com.dao.service;

import com.dao.model.Appointment;
import com.dao.model.FullAppointmentData;
import com.dao.model.Person;
import com.dao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private PersonServiceRepository personServiceRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Appointment find(Integer id) {
        return repository.findOne(id);
    }

    public FullAppointmentData findFull(Integer id) {
        FullAppointmentData app = new FullAppointmentData();
        app.setAppointment(find(id));
        app.setClient(clientRepository.findOne(app.getAppointment().getClientId()));
        app.setPersonServices(personServiceRepository.findByAppointmentId(id));
        app.setService(serviceRepository.findById(app.getAppointment().getServiceId()));

        return app;
    }

    public Appointment create(Appointment appointment) {
        return repository.save(appointment);
    }

    public Appointment update(Appointment appointment) {
        return repository.save(appointment);
    }

    public Appointment findLastByClientId(Integer clientId, Integer status) {
        return repository.findFirstByClientIdAndStateOrderByIdDesc(clientId, status);
    }
}

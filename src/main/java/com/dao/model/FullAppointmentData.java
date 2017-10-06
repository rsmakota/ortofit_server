package com.dao.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-10-06
 * Copyright  "Commercegate LTD"
 */
public class FullAppointmentData implements Serializable {
    private Appointment appointment;
    private Client client;
    private Service service;
    private List<PersonService> personServices;

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<PersonService> getPersonServices() {
        return personServices;
    }

    public void setPersonServices(List<PersonService> personServices) {
        this.personServices = personServices;
    }

}

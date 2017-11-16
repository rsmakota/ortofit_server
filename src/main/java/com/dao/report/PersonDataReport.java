package com.dao.report;

import com.dao.model.Person;
import com.dao.model.PersonService;
import com.dao.model.Reason;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-11-16
 * Copyright  "Commercegate LTD"
 */

public class PersonDataReport implements Serializable {
    private Person person;
    private List<PersonService> personServices;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<PersonService> getPersonServices() {
        return personServices;
    }

    public void setPersonServices(List<PersonService> personServices) {
        this.personServices = personServices;
    }
}

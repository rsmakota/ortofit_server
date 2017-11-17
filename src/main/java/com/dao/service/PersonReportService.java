package com.dao.service;

import com.dao.model.Person;
import com.dao.model.PersonService;
import com.dao.report.PersonDataReport;
import com.dao.repository.PersonRepository;
import com.dao.repository.PersonServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-11-16
 * Copyright  "Commercegate LTD"
 */
@Service
public class PersonReportService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonServiceRepository personServiceRepository;

    public List<PersonDataReport> findByClientIdAndAppointmentId(Integer clientId, Integer appointmentId) {
        List<PersonDataReport> personDataReports = new ArrayList<>();
        List<Person> persons = personRepository.findByClientId(clientId);

        for (Person person : persons) {
            List<PersonService> personServiceList = personServiceRepository.findByPersonIdAndAppointmentId(person.getId(), appointmentId);
            if (personServiceList == null || personServiceList.size() == 0) {
                continue;
            }
            PersonDataReport personDataReport = new PersonDataReport();
            personDataReport.setPerson(person);
            personDataReport.setPersonServices(personServiceList);
            personDataReports.add(personDataReport);
        }

        return personDataReports;
    }
}

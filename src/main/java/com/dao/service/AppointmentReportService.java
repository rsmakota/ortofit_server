package com.dao.service;

import com.dao.report.AppointmentReport;
import com.dao.repository.AppointmentReasonRepository;
import com.dao.repository.AppointmentReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-11-16
 * Copyright  "Commercegate LTD"
 */
@Service
public class AppointmentReportService {
    @Autowired
    PersonReportService personReportService;
    @Autowired
    AppointmentReasonRepository reasonRepository;
    @Autowired
    AppointmentReportRepository appointmentReportRepository;

    public List<AppointmentReport> findByClientId(Integer clientId) {
        List<AppointmentReport> appointmentReports = appointmentReportRepository.findByClientId(clientId);
        for (AppointmentReport report: appointmentReports) {
            report.setPersonData(personReportService.findByClientIdAndAppointmentId(clientId, report.getId()));
            report.setReasons(reasonRepository.findByAppointmentId(report.getId()));
        }

        return appointmentReports;
    }
}

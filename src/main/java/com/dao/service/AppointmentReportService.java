package com.dao.service;

import com.dao.model.User;
import com.dao.report.*;
import com.dao.repository.AppointmentReasonRepository;
import com.dao.repository.AppointmentReportRepository;
import com.dao.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
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
    @Autowired
    UserService userService;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    AppointmentService appointmentService;

    public List<AppointmentReport> findByClientId(Integer clientId) {
        List<AppointmentReport> appointmentReports = appointmentReportRepository.findByClientId(clientId);
        for (AppointmentReport report: appointmentReports) {
            report.setPersonData(personReportService.findByClientIdAndAppointmentId(clientId, report.getId()));
            report.setReasons(reasonRepository.findByAppointmentId(report.getId()));
        }

        return appointmentReports;
    }

    public List<TotalReport> findTotals(Timestamp from, Timestamp to, Integer officeId) {
        List<TotalReport> result = new ArrayList<>();
        List<User> users = userService.all();
        for (User user : users) {
            List<ServiceReport> serviceReports = appointmentReportRepository.findServiceReport(user.getId(), officeId, from, to);
            List<ForwardReport> forwardReports = appointmentReportRepository.findForwardReports(user.getId(), officeId, from, to);
            List<InsoleReport> insoleReports   = appointmentReportRepository.findInsoleReports(user.getId(), officeId, from, to);
            serviceReports = setInsoles(serviceReports, insoleReports);
            TotalReport report = createTotalReport(user, serviceReports, forwardReports);
            if (report != null) {
                result.add(report);
            }
        }

        return result;
    }

    private List<ServiceReport> setInsoles(List<ServiceReport>serviceReports, List<InsoleReport> insoleReports) {
        for (ServiceReport report : serviceReports) {
            if (report.getAlias().equals("insoles_manufacturing")) {
                report.setInsoles(insoleReports);
            }
        }
        return  serviceReports;
    }

    private TotalReport createTotalReport(User user, List<ServiceReport> serviceReports, List<ForwardReport> forwardReports) {
        if (serviceReports.isEmpty() && forwardReports.isEmpty()) {
            return null;
        }
        TotalReport report = new TotalReport();
        report.setDoctorName(user.getName());
        report.setServices(serviceReports);
        report.setForwards(forwardReports);

        return report;
    }

    public List<SettlementReport> findSettlements(Timestamp from, Timestamp to) {
        return appointmentReportRepository.findSettlementReport(from, to);
    }
}

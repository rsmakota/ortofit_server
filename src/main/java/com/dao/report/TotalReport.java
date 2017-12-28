package com.dao.report;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-12-28
 * Copyright  "Commercegate LTD"
 */
public class TotalReport implements Serializable {
    private String doctorName;
    private List<ServiceReport> services;
    private List<ForwardReport> forwards;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public List<ServiceReport> getServices() {
        return services;
    }

    public void setServices(List<ServiceReport> services) {
        this.services = services;
    }

    public List<ForwardReport> getForwards() {
        return forwards;
    }

    public void setForwards(List<ForwardReport> forwards) {
        this.forwards = forwards;
    }
}

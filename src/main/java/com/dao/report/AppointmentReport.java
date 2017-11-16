package com.dao.report;

import com.dao.model.AppointmentReason;
import com.dao.model.Reason;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-11-14
 * Copyright  "Commercegate LTD"
 */
public class AppointmentReport implements Serializable {
    private Integer id;
    private Timestamp dateTime;
    private String doctorName;
    private String officeName;
    private Integer state;
    private String serviceName;
    private List<PersonDataReport> personData;
    private List<AppointmentReason> reasons;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp date_time) {
        this.dateTime = dateTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<PersonDataReport> getPersonData() {
        return personData;
    }

    public void setPersonData(List<PersonDataReport> personData) {
        this.personData = personData;
    }

    public List<AppointmentReason> getReasons() {
        return reasons;
    }

    public void setReasons(List<AppointmentReason> reasons) {
        this.reasons = reasons;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}

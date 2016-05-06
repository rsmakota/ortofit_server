package com.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2016-05-06
 * Copyright  "Commercegate LTD"
 */
@Entity
@Table(name = "app_reminders", schema = "public", catalog = "ortofit")
public class AppReminder implements Serializable {
    private Integer id;
    private Appointment appointment;
    private Person person;
    private Timestamp dateTime;
    private String description;
    private Boolean processed;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointmentId) {
        this.appointment = appointmentId;
    }

    @ManyToOne
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Basic
    @Column(name = "date_time")
    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "processed")
    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppReminder that = (AppReminder) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (appointment != null ? !appointment.equals(that.appointment) : that.appointment != null)
            return false;
        if (person != null ? !person.equals(that.person) : that.person != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (processed != null ? !processed.equals(that.processed) : that.processed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (appointment != null ? appointment.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (processed != null ? processed.hashCode() : 0);
        return result;
    }
}

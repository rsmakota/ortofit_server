package com.dao.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2016-05-06
 * Copyright  "Commercegate LTD"
 */
@Entity
@Table(name = "appointments", schema = "public", catalog = "ortofit")
public class Appointment implements Serializable {

    @Id
    @GenericGenerator(
            name = "idAppointmentGen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "appointments_id_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "idAppointmentGen")
//    @SequenceGenerator(name = "idAppointmentGen", schema = "public", sequenceName = "appointments_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "client_id")
    private Integer clientId;
    @Column(name = "created")
    private Date created;
    @Column(name = "description")
    private String description;
    @Column(name = "office_id")
    private Integer officeId;
    @Column(name = "service_id")
    private Integer serviceId;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Kiev")
    @Column(name = "date_time")
    private Timestamp dateTime;
    @Column(name = "state")
    private Integer state;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "forwarder")
    private String forwarder;
    @Column(name = "bold")
    private Boolean bold = false;
    @Column(name = "flyer")
    private Boolean flyer = false;
    @Column(name = "phone_confirm")
    private Boolean phoneConfirm = false;



    public Appointment() {
        created = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }


    public String getForwarder() {
        return forwarder;
    }

    public void setForwarder(String forwarder) {
        this.forwarder = forwarder;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getBold() {
        return bold;
    }

    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    public Boolean getFlyer() {
        return flyer;
    }

    public void setFlyer(Boolean flyer) {
        this.flyer = flyer;
    }

    public Boolean getPhoneConfirm() {
        return phoneConfirm;
    }

    public void setPhoneConfirm(Boolean phoneConfirm) {
        this.phoneConfirm = phoneConfirm;
    }
}

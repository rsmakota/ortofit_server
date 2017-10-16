package com.dao.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2016-05-06
 * Copyright  "Commercegate LTD"
 */
@Entity
@Table(name = "appointment_reasons", schema = "public", catalog = "ortofit")
public class AppointmentReason implements Serializable {
    @Id
    @GenericGenerator(
            name = "idAppReasonGen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "appointment_reasons_id_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "idAppReasonGen")
//    @SequenceGenerator(name = "idAppReasonGen", schema = "public", sequenceName = "appointment_reasons_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "appointment_id")
    private Integer appointmentId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "reason_id")
    private Integer reasonId;
    @Column(name = "created")
    private Date created;


    public AppointmentReason() {
        created = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public Date getCreated() {
        return created;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getReasonId() {
        return reasonId;
    }

    public void setReasonId(Integer reasonId) {
        this.reasonId = reasonId;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

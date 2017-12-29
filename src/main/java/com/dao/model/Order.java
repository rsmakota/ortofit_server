package com.dao.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2016-05-06
 * Copyright  "Commercegate LTD"
 */
@Entity
@Table(name = "orders", schema = "public", catalog = "ortofit")
public class Order implements Serializable {
    @Id
    @GenericGenerator(
            name = "idOrderGen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "orders_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "idOrderGen")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "application_id")
    private Integer applicationId;
    @Column(name = "service_id")
    private Integer serviceId;
    @Column(name = "created")
    private Timestamp created;
    @Column(name = "processed")
    private Boolean processed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

}

package com.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2016-05-06
 * Copyright  "Commercegate LTD"
 */
@Entity
@Table(name = "clients", schema = "public", catalog = "ortofit")
public class Client implements Serializable {
    @Id
    @GeneratedValue(generator = "idClientGen")
    @SequenceGenerator(name = "idClientGen", schema = "public", sequenceName = "clients_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name = "msisdn")
    private String msisdn;
    @Column(name = "created")
    private Date created;
    @Column(name = "client_direction_id")
    private Integer clientDirectionId;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;

    public Client() {
        this.created = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getClientDirectionId() {
        return clientDirectionId;
    }

    public void setClientDirectionId(Integer clientDirectionId) {
        this.clientDirectionId = clientDirectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}

package com.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2016-05-06
 * Copyright  "Commercegate LTD"
 */
@Entity
@Table(name = "persons", schema = "public", catalog = "ortofit")
public class Person implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "family_status_id")
    private FamilyStatus familyStatus;
    @Column(name = "client_id")
    private Integer clientId;
    @Column(name = "name")
    private String name;
    @Column(name = "born")
    private Timestamp born;
    @Column(name = "created")
    private Timestamp created;
    @Column(name = "is_client")
    private Boolean isClient;
    @Column(name = "gender")
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FamilyStatus getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(FamilyStatus familyStatus) {
        this.familyStatus = familyStatus;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Boolean getClient() {
        return isClient;
    }

    public void setClient(Boolean client) {
        isClient = client;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getBorn() {
        return born;
    }

    public void setBorn(Timestamp born) {
        this.born = born;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }


}

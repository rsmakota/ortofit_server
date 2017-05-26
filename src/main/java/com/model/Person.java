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
@Table(name = "persons", schema = "public", catalog = "ortofit")
public class Person implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "family_status_id")
    private FamilyStatus familyStatus;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
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

    public Client getClient() {
        return client;
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

    public void setClient(Client client) {
        this.client = client;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (familyStatus != null ? !familyStatus.equals(person.familyStatus) : person.familyStatus != null)
            return false;
        if (client != null ? !client.equals(person.client) : person.client != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (born != null ? !born.equals(person.born) : person.born != null) return false;
        if (created != null ? !created.equals(person.created) : person.created != null) return false;
        if (isClient != null ? !isClient.equals(person.isClient) : person.isClient != null) return false;
        if (gender != null ? !gender.equals(person.gender) : person.gender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (familyStatus != null ? familyStatus.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (born != null ? born.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (isClient != null ? isClient.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}

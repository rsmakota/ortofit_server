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
@Table(name = "clients", schema = "public", catalog = "ortofit")
public class Client implements Serializable {
    private Integer id;
    private Country country;
    private String msisdn;
    private Timestamp created;
    private ClientDirection clientDirection;
    private String name;
    private String gender;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "country_id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Basic
    @Column(name = "msisdn")
    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @Basic
    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @ManyToOne
    @JoinColumn(name = "client_direction_id")
    public ClientDirection getClientDirection() {
        return clientDirection;
    }

    public void setClientDirection(ClientDirection clientDirection) {
        this.clientDirection = clientDirection;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client clients = (Client) o;

        if (id != null ? !id.equals(clients.id) : clients.id != null) return false;
        if (country != null ? !country.equals(clients.country) : clients.country != null) return false;
        if (msisdn != null ? !msisdn.equals(clients.msisdn) : clients.msisdn != null) return false;
        if (created != null ? !created.equals(clients.created) : clients.created != null) return false;
        if (clientDirection != null ? !clientDirection.equals(clients.clientDirection) : clients.clientDirection != null)
            return false;
        if (name != null ? !name.equals(clients.name) : clients.name != null) return false;
        if (gender != null ? !gender.equals(clients.gender) : clients.gender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (msisdn != null ? msisdn.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (clientDirection != null ? clientDirection.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}

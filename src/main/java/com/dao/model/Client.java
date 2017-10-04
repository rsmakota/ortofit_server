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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @Column(name = "msisdn")
    private String msisdn;
    @Column(name = "created")
    private Date created;
    @ManyToOne
    @JoinColumn(name = "client_direction_id")
    private ClientDirection clientDirection;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public ClientDirection getClientDirection() {
        return clientDirection;
    }

    public void setClientDirection(ClientDirection clientDirection) {
        this.clientDirection = clientDirection;
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

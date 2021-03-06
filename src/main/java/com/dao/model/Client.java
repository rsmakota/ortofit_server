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
@Table(name = "clients", schema = "public", catalog = "ortofit")
public class Client implements Serializable {
    @Id
    @GenericGenerator(
            name = "idClientGen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "clients_id_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "idClientGen")
//    @SequenceGenerator(name = "idClientGen", schema = "public", sequenceName = "clients_id_seq", allocationSize = 1)
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

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
}

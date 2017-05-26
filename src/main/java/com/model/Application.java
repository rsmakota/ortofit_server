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
@Table(name = "applications", schema = "public", catalog = "ortofit")
public class Application implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_direction_id")
    private ClientDirection clientDirection;
    @Column(name = "name")
    private String name;
    @Column(name = "created")
    private Timestamp created;
    @Column(name = "type")
    private String type;
    @Column(name = "flow_service_name")
    private String flowServiceName;
    @Column(name = "config")
    private String config;


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

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlowServiceName() {
        return flowServiceName;
    }

    public void setFlowServiceName(String flowServiceName) {
        this.flowServiceName = flowServiceName;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Application that = (Application) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (clientDirection != null ? !clientDirection.equals(that.clientDirection) : that.clientDirection != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (flowServiceName != null ? !flowServiceName.equals(that.flowServiceName) : that.flowServiceName != null)
            return false;
        if (config != null ? !config.equals(that.config) : that.config != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (clientDirection != null ? clientDirection.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (flowServiceName != null ? flowServiceName.hashCode() : 0);
        result = 31 * result + (config != null ? config.hashCode() : 0);
        return result;
    }
}

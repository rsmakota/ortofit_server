package com.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2016-05-06
 * Copyright  "Commercegate LTD"
 */
@Entity
@Table(name = "cities", schema = "public", catalog = "ortofit")
public class City implements Serializable {
    private Integer id;
    private Country country;
    private String name;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (!id.equals(city.id)) return false;
        if (!country.equals(city.country)) return false;
        return name.equals(city.name);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}

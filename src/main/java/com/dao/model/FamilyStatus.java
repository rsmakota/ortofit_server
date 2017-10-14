package com.dao.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2016-05-06
 * Copyright  "Commercegate LTD"
 */
@Entity
@Table(name = "family_statuses", schema = "public", catalog = "ortofit")
public class FamilyStatus implements Serializable {
    @Id
    @GeneratedValue(generator = "idFamStatGen")
    @SequenceGenerator(name = "idFamStatGen", schema = "public", sequenceName = "family_statuses_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "general")
    private Boolean general;
    @Column(name = "alias")
    private String alias;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGeneral() {
        return general;
    }

    public void setGeneral(Boolean general) {
        this.general = general;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}

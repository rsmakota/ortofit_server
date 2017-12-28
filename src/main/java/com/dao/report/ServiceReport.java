package com.dao.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-12-28
 * Copyright  "Commercegate LTD"
 */
public class ServiceReport implements Serializable {
    private String alias;
    private String name;
    private Integer total;
    private List<InsoleReport> insoles;

    public ServiceReport() {
        insoles = new ArrayList<>();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<InsoleReport> getInsoles() {
        return insoles;
    }

    public void setInsoles(List<InsoleReport> insoles) {
        this.insoles = insoles;
    }
}

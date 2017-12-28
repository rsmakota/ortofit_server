package com.dao.report;

import java.io.Serializable;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-12-28
 * Copyright  "Commercegate LTD"
 */
public class InsoleReport implements Serializable {
    private String name;
    private Integer total;
    private String[] sizes;

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

    public String[] getSizes() {
        return sizes;
    }

    public void setSizes(String[] sizes) {
        this.sizes = sizes;
    }
}

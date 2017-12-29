package com.dao.report;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-12-29
 * Copyright  "Commercegate LTD"
 */
public class NotificationReport {
    private Integer reminds;
    private Integer orders;

    public Integer getReminds() {
        return reminds;
    }

    public void setReminds(Integer reminds) {
        this.reminds = reminds;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}

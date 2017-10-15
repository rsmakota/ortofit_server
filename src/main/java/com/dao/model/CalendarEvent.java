package com.dao.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-11
 * Copyright  "Commercegate LTD"
 */
public class CalendarEvent implements Serializable, ICalendarEvent {

    final public static int STATE_NEW          = 1;
    final public static int STATE_RECORD       = 2;
    final public static int STATE_CLOSE_REASON = 3;
    final public static int STATE_SUCCESS      = 4;

    private String id;
    private String title;
    private String start;
    private String end;
    private String backgroundColor;
    private String borderColor;
    private String textColor;
    private Boolean phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public Boolean getPhone() {
        return phone;
    }

    public void setPhone(Boolean phone) {
        this.phone = phone;
    }

    @Override
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @Override
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}

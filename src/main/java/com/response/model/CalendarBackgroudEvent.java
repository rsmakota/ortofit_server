package com.response.model;

import com.response.model.ICalendarEvent;

import java.io.Serializable;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-25
 * Copyright  "Commercegate LTD"
 */
public class CalendarBackgroudEvent implements Serializable, ICalendarEvent {
    private String id;
    private String title;
    private String backgroundColor;
    private String rendering;
    private String start;
    private String end;

    public CalendarBackgroudEvent() {
        this.id = "available_hours";
        this.rendering = "inverse-background";
        this.backgroundColor = "#cccccc";
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
    public String getColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getRendering() {
        return rendering;
    }
}

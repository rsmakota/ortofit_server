package com.response.wrapper;

import com.dao.model.Schedule;
import com.dao.model.User;
import com.response.model.ICalendarEvent;
import java.io.Serializable;
/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-12-11
 * Copyright  "Commercegate LTD"
 */
public class StaffScheduleWrapper implements ICalendarEvent, Serializable {

    private String backgroundColor = "#222D32";
    private String borderColor = "#222D32";
    private String textColor = "#222D32";
    private Schedule schedule;
    private User user;

    public StaffScheduleWrapper(Schedule schedule, User user) {
        this.schedule = schedule;
        this.user = user;
    }

    public String getTitle() {
        return (user != null) ? user.getName() : "";
    }

    @Override
    public String getId() {
        return schedule.getId().toString();
    }

    @Override
    public String getStart() {
        return schedule.getStartDate().toString();
    }

    @Override
    public String getEnd() {
        return schedule.getEndDate().toString();
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public String getTextColor() {
        return textColor;
    }
}

package com.response.model;

import java.sql.Timestamp;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-25
 * Copyright  "Commercegate LTD"
 */
public interface ICalendarEvent {
    public String getId();
    public String getStart();
    public String getEnd();
}

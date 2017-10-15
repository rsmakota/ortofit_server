package com.dao.mapper;

import com.dao.model.CalendarEvent;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-11
 * Copyright  "Commercegate LTD"
 */
public class CalendarEventMapper implements RowMapper<CalendarEvent> {

    @Override
    public CalendarEvent mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer state      = resultSet.getInt("state");
        Boolean isBold     = resultSet.getBoolean("bold");
        String description = resultSet.getString("description");
        String reason      = resultSet.getString("reason");

        CalendarEvent event = new CalendarEvent();
        event.setId(resultSet.getString("id"));
        event.setTitle(resultSet.getString("title"));
        event.setStart(resultSet.getString("start"));
        event.setEnd(resultSet.getString("end"));
        event.setBackgroundColor(resultSet.getString("backgroundColor"));
        event.setBorderColor(resultSet.getString("borderColor"));
        event.setTextColor("#000000");
        event.setPhone(resultSet.getBoolean("phone"));
        if (isBold) {
            fillBold(event, reason);
            return event;
        }

        switch (state) {
            case CalendarEvent.STATE_NEW:
                break;
            case CalendarEvent.STATE_SUCCESS:
                fillSuccess(event);
                break;
            case CalendarEvent.STATE_CLOSE_REASON:
                fillCloseReason(event, description);
        }

        return event;
    }

    private void fillSuccess(CalendarEvent event) {
        event.setTitle(event.getTitle() + " Оформлен");
        event.setBackgroundColor("#35682D");
        event.setBorderColor("#35682D");
    }

    private void fillCloseReason(CalendarEvent event, String reason) {
        event.setBackgroundColor("#757777");
        event.setBorderColor("#757777");
        event.setTitle(event.getTitle() + " " + reason);
    }

    private void fillBold(CalendarEvent event, String description) {
        event.setBackgroundColor("#ff001d");
        event.setBorderColor("#000000");
        event.setTextColor("#ffffff");
        event.setTitle(event.getTitle() + " " + description);
    }


//
//
//    private String defineBgColor(ResultSet resultSet) throws SQLException {
//        Integer state  = resultSet.getInt("state");
//        Boolean isBold = resultSet.getBoolean("bold");
//        if (isBold) {
//            return "#ff001d";
//        }
//        switch (state) {
//            case CalendarEvent.STATE_NEW :
//                return resultSet.getString("backgroundColor");
//            case CalendarEvent.STATE_SUCCESS :
//                return "#35682D";
//            case CalendarEvent.STATE_CLOSE_REASON:
//                return "#757777";
//        }
//
//        return "";
//    }
//
//    private String defineBrColor(ResultSet resultSet) throws SQLException {
//        Integer state  = resultSet.getInt("state");
//        Boolean isBold = resultSet.getBoolean("bold");
//        if (isBold) {
//            return "#000000";
//        }
//        switch (state) {
//            case CalendarEvent.STATE_NEW:
//                return resultSet.getString("borderColor");
//            case CalendarEvent.STATE_SUCCESS:
//                return "#35682D";
//            case CalendarEvent.STATE_CLOSE_REASON:
//                return "#757777";
//        }
//
//        return "";
//    }
//
//
//    private String defineTextColor(ResultSet resultSet) throws SQLException {
//
//    }
}

package com.dao.mapper;

import com.dao.report.ForwardReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-11
 * Copyright  "Commercegate LTD"
 */
public class ForwardReportMapper implements RowMapper<ForwardReport> {
    @Override
    public ForwardReport mapRow(ResultSet resultSet, int i) throws SQLException {
        ForwardReport forwardReport = new ForwardReport();
        forwardReport.setFlyers(resultSet.getInt("flyer"));
        forwardReport.setName(resultSet.getString("name"));
        forwardReport.setTotal(resultSet.getInt("total"));

        return forwardReport;
    }
}

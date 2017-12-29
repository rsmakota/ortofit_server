package com.dao.mapper;

import com.dao.report.ServiceReport;
import com.dao.report.SettlementReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-11
 * Copyright  "Commercegate LTD"
 */
public class SettlementReportMapper implements RowMapper<SettlementReport> {
    @Override
    public SettlementReport mapRow(ResultSet resultSet, int i) throws SQLException {
        SettlementReport serviceReport = new SettlementReport();
        serviceReport.setName(resultSet.getString("name"));
        serviceReport.setTotal(resultSet.getInt("total"));

        return serviceReport;
    }
}

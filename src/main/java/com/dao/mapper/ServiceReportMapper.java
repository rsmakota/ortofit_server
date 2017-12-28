package com.dao.mapper;

import com.dao.report.ServiceReport;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-11
 * Copyright  "Commercegate LTD"
 */
public class ServiceReportMapper implements RowMapper<ServiceReport> {
    @Override
    public ServiceReport mapRow(ResultSet resultSet, int i) throws SQLException {
        ServiceReport serviceReport = new ServiceReport();
        serviceReport.setAlias(resultSet.getString("alias"));
        serviceReport.setName(resultSet.getString("name"));
        serviceReport.setTotal(resultSet.getInt("total"));

        return serviceReport;
    }
}

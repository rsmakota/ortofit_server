package com.dao.mapper;

import com.dao.report.InsoleReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-11
 * Copyright  "Commercegate LTD"
 */
public class InsoleReportMapper implements RowMapper<InsoleReport> {
    @Override
    public InsoleReport mapRow(ResultSet resultSet, int i) throws SQLException {
        InsoleReport insoleReport = new InsoleReport();
        String[] sizes = (String[]) resultSet.getArray("sizes").getArray();
        insoleReport.setSizes(sizes);
        insoleReport.setName(resultSet.getString("name"));
        insoleReport.setTotal(resultSet.getInt("total"));

        return insoleReport;
    }
}

package com.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-08-02
 * Copyright  "Commercegate LTD"
 */
@EnableJpaRepositories(basePackages = "com.dao.repository")
@EntityScan(basePackages = "com.modal")
public class DataConfiguration {
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }
}

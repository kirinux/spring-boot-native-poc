package com.ing.payment.poc.springbootnativeimage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Bean("edlJdbcTemplate")
    public NamedParameterJdbcTemplate edlJdbcTemplate(DataSource edlDataSource) {
        return new NamedParameterJdbcTemplate(edlDataSource);
    }

    @Bean
    public ApplicationRunner applicationRunner(DataSource edlDataSource) {
        return args -> {
            try {
                edlDataSource.getConnection();
            } catch (Exception e) {

            }
        };
    }

}

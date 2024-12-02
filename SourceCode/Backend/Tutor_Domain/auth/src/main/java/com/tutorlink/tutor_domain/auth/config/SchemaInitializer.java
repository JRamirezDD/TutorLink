package com.tutorlink.tutor_domain.auth.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class SchemaInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public SchemaInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Value("${spring.jpa.properties.hibernate.default_schema}")
    public String schemaName;

    @Override
    public void run(String... args) {
        // Create schema if it doesn't exist
        jdbcTemplate.execute("CREATE SCHEMA IF NOT EXISTS " + schemaName);

        System.out.println("Schema ensured: " + schemaName);
    }
}

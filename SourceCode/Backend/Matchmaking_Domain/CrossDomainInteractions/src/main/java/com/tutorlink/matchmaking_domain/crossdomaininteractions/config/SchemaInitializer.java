package com.tutorlink.matchmaking_domain.crossdomaininteractions.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SchemaInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    // Constructor to inject JdbcTemplate
    public SchemaInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Value for the schema name from application properties
    @Value("${spring.jpa.properties.hibernate.default_schema}")
    private String schemaName;

    // Override the run method from CommandLineRunner interface
    @Override
    public void run(String... args) throws Exception {
        // Create schema if it doesn't exist
        jdbcTemplate.execute("CREATE SCHEMA IF NOT EXISTS " + schemaName);
        System.out.println("Schema ensured: " + schemaName);
    }
}

package com.example.logbookback.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbSmokeTest implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DbSmokeTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        Integer one = jdbcTemplate.queryForObject("select 1", Integer.class);
        System.out.println("DB OK, select 1 -> " + one);
    }
}

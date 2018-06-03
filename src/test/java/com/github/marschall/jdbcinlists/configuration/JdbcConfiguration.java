package com.github.marschall.jdbcinlists.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcConfiguration {

  @Autowired
  private DataSource dataSource;

  @Bean
  public JdbcOperations jdbcTemplate() {
    return new JdbcTemplate(this.dataSource);
  }

}

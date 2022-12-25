package com.github.marschall.jdbcinlists.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@Configuration
public class HanaConfiguration {

  @Bean
  public DataSource dataSource() {
    com.sap.db.jdbc.Driver.getInstance();
    SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
    dataSource.setSuppressClose(true);
    dataSource.setUrl("jdbc:sap://localhost:39017/?statementCacheSize=0");
    dataSource.setUsername("SYSTEM");
    String password = "H1bernate_test";
    dataSource.setPassword(password);
    return dataSource;
  }

}

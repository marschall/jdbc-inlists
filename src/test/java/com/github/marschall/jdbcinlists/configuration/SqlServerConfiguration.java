package com.github.marschall.jdbcinlists.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@Configuration
public class SqlServerConfiguration {

  @Bean
  public DataSource dataSource() {
    if (!com.microsoft.sqlserver.jdbc.SQLServerDriver.isRegistered()) {
      try {
        com.microsoft.sqlserver.jdbc.SQLServerDriver.register();
      } catch (SQLException e) {
        throw new BeanCreationException("dataSource", "could not register driver", e);
      }
    }
    var dataSource = new SingleConnectionDataSource();
    dataSource.setSuppressClose(true);
    dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=master;encrypt=false");
    dataSource.setUsername("sa");
    dataSource.setPassword("Cent-Quick-Space-Bath-8");
    return dataSource;
  }

}

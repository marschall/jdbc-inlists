package com.github.marschall.jdbcinlists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.marschall.jdbcinlists.configuration.JdbcConfiguration;
import com.github.marschall.jdbcinlists.configuration.TransactionManagerConfiguration;

@SpringJUnitConfig(classes = {TransactionManagerConfiguration.class, JdbcConfiguration.class})
abstract class AbstractInListTest {

  private static final String QUERY = "SELECT val "
          + "FROM inlist_test_table "
          + "WHERE id = ANY(?) "
          + "ORDER BY id";

  @Autowired
  private JdbcOperations jdbcTemplate;

  @Test
  void selectInlist() {
    var values = this.jdbcTemplate.queryForList(QUERY, String.class, new SqlArrayValue("smallint", 3, 5));
    assertEquals(Arrays.asList("Value_00003", "Value_00005"), values);
  }

}
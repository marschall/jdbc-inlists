package com.github.marschall.jdbcinlists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.marschall.jdbcinlists.configuration.JdbcConfiguration;
import com.github.marschall.jdbcinlists.configuration.TransactionManagerConfiguration;

@SpringJUnitConfig(classes = {TransactionManagerConfiguration.class, JdbcConfiguration.class})
abstract class AbstractInListTest {

  private static final String QUERY = """
                                      SELECT val
                                      FROM inlist_test_table
                                      WHERE id = ANY(?)
                                      ORDER BY id
                                      """;

  @Autowired
  private DataSource dataSource;

  @Autowired
  private JdbcOperations jdbcTemplate;

  @Test
  void jdbcTemplate() {
    var values = this.jdbcTemplate.queryForList(this.getQuery(), String.class, new SqlArrayValue("smallint", 3, 5));
    assertEquals(Arrays.asList("Value_00003", "Value_00005"), values);
  }

  @Test
  void plainJdbc() throws SQLException {
    try (var connection = this.dataSource.getConnection();
         var preparedStatement = connection.prepareStatement(this.getQuery())) {
      var array = connection.createArrayOf("smallint", new Object[] {3, 5});
      try {
        preparedStatement.setArray(1, array);

        List<String> values = new ArrayList<>(2);
        try (var resultSet = preparedStatement.executeQuery()) {
          while (resultSet.next()) {
            values.add(resultSet.getString(1));
          }
        }
        assertEquals(Arrays.asList("Value_00003", "Value_00005"), values);
      } finally {
        array.free();
      }
    }
  }

  String getQuery() {
    return QUERY;
  }

}
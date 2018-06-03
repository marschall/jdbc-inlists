package com.github.marschall.jdbcinlists;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.marschall.jdbcinlists.configuration.HsqlConfiguration;

@SpringJUnitConfig(classes = HsqlConfiguration.class)
class HsqlInListTest extends AbstractInListTest {

  private static final String QUERY = "SELECT val "
          + "FROM inlist_test_table "
          + "WHERE id = ANY(CAST(? AS INT ARRAY)) "
          + "ORDER BY id";

  @Override
  String getQuery() {
    return QUERY;
  }

}

package com.github.marschall.jdbcinlists;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.marschall.jdbcinlists.configuration.HsqlConfiguration;

@SpringJUnitConfig(classes = HsqlConfiguration.class)
class HsqlInListTest extends AbstractInListTest {

  // https://stackoverflow.com/questions/50665451/hsqldb-any-array-function-not-working
  private static final String QUERY = "SELECT val "
          + "FROM inlist_test_table "
          + "WHERE id IN ( UNNEST(?) ) "
          + "ORDER BY id";

  @Override
  String getQuery() {
    return QUERY;
  }

}

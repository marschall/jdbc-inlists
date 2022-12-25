package com.github.marschall.jdbcinlists;

import org.junit.jupiter.api.Disabled;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.marschall.jdbcinlists.configuration.HanaConfiguration;

@Disabled("HANA does not support arrays")
@SpringJUnitConfig(classes = HanaConfiguration.class)
class HanaInListTest extends AbstractInListTest {

  private static final String QUERY = """
                                      SELECT val
                                      FROM inlist_test_table
                                      WHERE id IN ( UNNEST(?) )
                                      ORDER BY id
                                      """;

  @Override
  String getQuery() {
    return QUERY;
  }

}

package com.github.marschall.jdbcinlists;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.marschall.jdbcinlists.configuration.PostgresConfiguration;

@SpringJUnitConfig(classes = PostgresConfiguration.class)
@Sql("classpath:common-schema.sql")
@Sql("classpath:common-data.sql")
class PostgresInListTest extends AbstractInListTest {

}

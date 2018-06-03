package com.github.marschall.jdbcinlists;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.marschall.jdbcinlists.configuration.PostgresConfiguration;

@SpringJUnitConfig(classes = PostgresConfiguration.class)
@Sql("classpath:postgres-schema.sql")
@Sql("classpath:postgres-data.sql")
class PostgresInListTest extends AbstractInListTest {

}

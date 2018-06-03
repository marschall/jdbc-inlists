package com.github.marschall.jdbcinlists;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.marschall.jdbcinlists.configuration.FirebirdConfiguration;

@SpringJUnitConfig(classes = FirebirdConfiguration.class)
@Sql(
        scripts = "classpath:firebird-schema.sql",
        config = @SqlConfig(separator = "!!"))
@Sql("classpath:common-data.sql")
class FirebirdInListTest extends AbstractInListTest {

}

package com.github.marschall.jdbcinlists;

import org.junit.jupiter.api.Disabled;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.marschall.jdbcinlists.configuration.DerbyConfiguration;


@Disabled("Derby does not support arrays")
@SpringJUnitConfig(classes = DerbyConfiguration.class)
class DerbyInListTest extends AbstractInListTest {

}

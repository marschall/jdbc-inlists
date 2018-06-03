package com.github.marschall.jdbcinlists;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.github.marschall.jdbcinlists.configuration.H2Configuration;

@SpringJUnitConfig(classes = H2Configuration.class)
class H2InListTest extends AbstractInListTest {

}

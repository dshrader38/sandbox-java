package com.shrader.namescore.shell.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.shell.Shell
import org.springframework.test.context.ContextConfiguration
import spock.lang.Shared
import spock.lang.Specification

import static org.springframework.util.ReflectionUtils.findMethod

/**
 * Illustrative integration tests for the Spring Shell Calculator application. These
 * integration tests use Spring Shell auto-wired by the Spring Test Runner.
 */
@SpringBootTest
@ContextConfiguration(classes = [ShellControllerIntegrationSpecConfig.class, ShellController.class])
class ShellControllerIntegrationSpec extends Specification {

    @Shared
    def COMMAND_CLASS_UNDER_TEST = ShellController.class

    @Autowired
    Shell shell

    /**
     * Test "happy path" or basic addition with positive numbers and zeroes. Use Spring Shell
     * auto-wired by the Spring Test Runner.
     */
    def "test add"() {
        given:
            def methodTarget = com.shrader.namescore.SpecUtils.lookupCommand(shell, "add")

        expect:
            methodTarget != null
            methodTarget.getGroup() == "Name Score Commands"
            methodTarget.getHelp() == "Add two integers"
            methodTarget.getAvailability().isAvailable()
            methodTarget.getMethod().is(findMethod(COMMAND_CLASS_UNDER_TEST, "add", int.class, int.class))
            //assertThat(shell.evaluate(() -> command + " 1 2"), is(3));
    }
}
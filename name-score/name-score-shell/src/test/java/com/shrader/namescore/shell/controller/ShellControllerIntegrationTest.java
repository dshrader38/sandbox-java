package com.shrader.namescore.shell.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.MethodTarget;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.shrader.namescore.TestUtils.lookupCommand;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.util.ReflectionUtils.findMethod;


/**
 * Illustrative integration tests for the Spring Shell Calculator application. These
 * integration tests use Spring Shell auto-wired by the Spring Test Runner.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(properties = {InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=" + false})
@ContextConfiguration(classes = ShellControllerIntegrationTestConfig.class)
public class ShellControllerIntegrationTest {

    private static final Class<ShellController> COMMAND_CLASS_UNDER_TEST = ShellController.class;

    @Autowired
    private Shell shell;

    @Test
    public void testAdd() {
        final String command = "add";

        final MethodTarget commandTarget = lookupCommand(shell, command);
        assertThat(commandTarget, notNullValue());
        assertThat(commandTarget.getGroup(), is("Name Score Commands"));
        assertThat(commandTarget.getHelp(), is("Add two integers"));
        assertThat(commandTarget.getMethod(), is(findMethod(COMMAND_CLASS_UNDER_TEST, command, int.class, int.class)));
        assertThat(commandTarget.getAvailability().isAvailable(), is(true));
        assertThat(shell.evaluate(() -> command + " 1 2"), is(3));
    }
}

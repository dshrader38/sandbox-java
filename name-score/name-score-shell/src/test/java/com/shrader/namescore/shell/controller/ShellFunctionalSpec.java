package com.shrader.namescore.shell.controller;

import com.shrader.namescore.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.shell.ConfigurableCommandRegistry;
import org.springframework.shell.MethodTarget;
import org.springframework.shell.standard.StandardMethodTargetRegistrar;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.util.ReflectionUtils.findMethod;


/**
 * Illustrative functional tests for the Spring Shell NameScore application. These
 * functional tests use Spring Shell commands auto-wired by the Spring Test Runner outside
 * of the shell, to test functionality of the commands.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ShellControllerConfig.class, ShellController.class})
public class ShellFunctionalSpec {

    private static final Class<ShellController> COMMAND_CLASS_UNDER_TEST = ShellController.class;
    private final ConfigurableCommandRegistry registry = new ConfigurableCommandRegistry();

    @Autowired
    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        final StandardMethodTargetRegistrar registrar = new StandardMethodTargetRegistrar();
        registrar.setApplicationContext(applicationContext);
        registrar.register(registry);
    }

    @Test
    public void testScoreFile() {
        // actual method name in class
        final String methodName = "scoreFile";

        // method name translation by spring shell (lowercase, hyphenated), which can be the same but isn't in this case
        final String command = "score-file";

        final MethodTarget methodTarget = TestUtils.lookupCommand(registry, command);
        assertThat(methodTarget, notNullValue());
        assertThat(methodTarget.getGroup(), is("Name Score Commands"));
        assertThat(methodTarget.getHelp(), is("Score a flat file containing a single line csv of names"));
        assertThat(methodTarget.getAvailability().isAvailable(), is(true));
        assertThat(methodTarget.getMethod(),
               is(findMethod(COMMAND_CLASS_UNDER_TEST, methodName, String.class, String.class, String.class)));

        String file = TestUtils.getResourceFilePath(COMMAND_CLASS_UNDER_TEST, "SmallFile.csv");
        assertThat(TestUtils.invoke(methodTarget, file, "FIRST", ","), is(2927));
        //assertEquals(3, ReflectionUtils.invokeMethod(methodTarget.getMethod(), methodTarget.getBean(), 1, 2));
    }

    @Test
    public void testAdd() {
        // actual method name in class
        final String methodName = "add";

        // method name translation by spring shell (lowercase, hyphenated), which is the same in this case
        final String command = "add";

        final MethodTarget methodTarget = TestUtils.lookupCommand(registry, command);
        assertThat(methodTarget, notNullValue());
        assertThat(methodTarget.getGroup(), is("Name Score Commands"));
        assertThat(methodTarget.getHelp(), is("Add two integers"));
        assertThat(methodTarget.getMethod(),
                is(findMethod(COMMAND_CLASS_UNDER_TEST, methodName, int.class, int.class)));
        assertThat(methodTarget.getAvailability().isAvailable(), is(true));

        assertThat(TestUtils.invoke(methodTarget, 1, 2), is(3));
    }
}
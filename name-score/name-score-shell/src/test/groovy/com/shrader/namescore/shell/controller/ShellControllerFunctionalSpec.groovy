package com.shrader.namescore.shell.controller

import com.shrader.namescore.SpecUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.core.io.ResourceLoader
import org.springframework.shell.ConfigurableCommandRegistry
import org.springframework.shell.standard.StandardMethodTargetRegistrar
import org.springframework.test.context.ContextConfiguration
import spock.lang.Shared
import spock.lang.Specification

import static org.springframework.util.ReflectionUtils.findMethod

/**
 * Illustrative functional tests for the Spring Shell NameScore application. These
 * functional tests use Spring Shell commands auto-wired by the Spring Test Runner outside
 * of the shell, to test functionality of the commands.
 */
//evaluate SpecUtil
@ContextConfiguration(classes = [ShellControllerFunctionalSpecConfig.class, ShellController.class])
class ShellControllerFunctionalSpec extends Specification {

    @Autowired
    ApplicationContext applicationContext

    @Autowired
    ResourceLoader resourceLoader

    @Shared
    def COMMAND_CLASS_UNDER_TEST = ShellController.class

    def registry = new ConfigurableCommandRegistry()

    def setup() {
        def registrar = new StandardMethodTargetRegistrar()
        registrar.setApplicationContext(applicationContext)
        registrar.register(registry)
    }

    def "validate add command"() {
        given:
            def methodTarget = SpecUtils.lookupCommand(registry, "add")

        expect:
            methodTarget != null
            methodTarget.getGroup() == "Name Score Commands"
            methodTarget.getHelp() == "Add two integers"
            methodTarget.getAvailability().isAvailable()
            methodTarget.getMethod().is(findMethod(COMMAND_CLASS_UNDER_TEST, "add", int.class, int.class))
    }

    def "test add command"() {
        given:
            def methodTarget = SpecUtils.lookupCommand(registry, "add")

        expect:
            SpecUtils.invoke(methodTarget, 1, 2) == 3
    }

    def "validate score-file command"() {
        given:
            def methodTarget = SpecUtils.lookupCommand(registry, "score-file")

        expect:
            methodTarget != null
            methodTarget.getGroup() == "Name Score Commands"
            methodTarget.getHelp() == "Score a flat file containing a single line csv of names"
            methodTarget.getAvailability().isAvailable()
            methodTarget.getMethod().is(findMethod(COMMAND_CLASS_UNDER_TEST, "scoreFile", String.class, String.class, String.class))
    }

    def "test score-file command"() {
        given:
            def methodTarget = SpecUtils.lookupCommand(registry, "score-file")

        when:
            def resource = this.resourceLoader.getResource("SmallFile.csv")
            def file = resource.getFile().getAbsolutePath()

        then:
            SpecUtils.invoke(methodTarget, file, "FIRST", ",") == 2927
    }
}
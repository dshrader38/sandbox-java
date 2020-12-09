package com.shrader.namescore.cli

import com.shrader.namescore.SpecUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.core.io.ResourceLoader
import org.springframework.shell.ConfigurableCommandRegistry
import org.springframework.shell.standard.StandardMethodTargetRegistrar
import org.springframework.test.context.ContextConfiguration
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.util.ReflectionUtils.findMethod


@ContextConfiguration(classes = [CliControllerConfig.class, Controller.class])
class CliControllerFunctionalSpec extends Specification {

    @Autowired
    ApplicationContext applicationContext

    @Autowired
    ResourceLoader resourceLoader

    @Shared
    def COMMAND_CLASS_UNDER_TEST = Controller.class

    def registry = new ConfigurableCommandRegistry()

    def setup() {
        def registrar = new StandardMethodTargetRegistrar()
        registrar.setApplicationContext(applicationContext)
        registrar.register(registry)
    }

    def "validate score-file command"() {
        when:
            def methodTarget = SpecUtils.lookupCommand(registry, "score-file")

        then:
            methodTarget != null
            methodTarget.getGroup() == "Name Score Commands"
            methodTarget.getHelp() == "Score a flat file containing a single line csv of names"
            methodTarget.getAvailability().isAvailable()
            methodTarget.getMethod().is(findMethod(COMMAND_CLASS_UNDER_TEST, "scoreFile", String.class, String.class, String.class))
    }

    @Unroll
    def "test score-file command"(String strategy, int expectedScore) {
        given:
            def methodTarget = SpecUtils.lookupCommand(registry, "score-file")

        and:
            def file = this.resourceLoader
                    .getResource("file:src/main/resources/SmallFile.csv")
                    .getFile()
                    .getAbsolutePath()

        when:
            def score = SpecUtils.invoke(methodTarget, file, strategy, ",")

        then:
            score == expectedScore

        where:
            strategy | expectedScore
            "first"  | 2927
            "second" | 2927
            "third"  | 2927
    }
}
package com.shrader.namescore.shell

import com.shrader.namescore.SpecUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.ResourceLoader
import org.springframework.shell.ConfigurableCommandRegistry
import org.springframework.shell.standard.StandardMethodTargetRegistrar
import org.springframework.test.context.ContextConfiguration
import spock.lang.Shared
import spock.lang.Specification

import static org.springframework.util.ReflectionUtils.findMethod


@ContextConfiguration(classes = [ShellControllerConfig.class, Controller.class])
class ShellControllerFunctionalSpec extends Specification {

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

    def "test score-file command"() {
        when:
            def methodTarget = SpecUtils.lookupCommand(registry, "score-file")

        and:
            def file = this.resourceLoader
                    .getResource("file:SmallFile.csv")
                    .getFile()
                    .getAbsolutePath()

            def file2 = new ClassPathResource("SmallFile.csv")
                    .getFile()
                    .getAbsolutePath()
            def result = 38


        then:
            SpecUtils.invoke(methodTarget, file2, "FIRST", ",") == 2927
    }
}
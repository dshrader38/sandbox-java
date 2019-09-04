package com.shrader.namescore.shell.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ResourceLoader
import org.springframework.shell.Shell
import org.springframework.shell.jline.InteractiveShellApplicationRunner
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification


@SpringBootTest(properties = InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=" + false)
@ContextConfiguration(classes = [ShellControllerIntegrationSpecConfig.class])
class ShellControllerIntegrationSpec extends Specification {

    @Autowired
    Shell shell

    @Autowired
    ResourceLoader resourceLoader


    def "test score-file command"() {
        given:
            def strategy = "FIRST"

        and:
            def file = this.resourceLoader
                    .getResource("file:src/main/resources/SmallFile.csv")
                    .getFile()
                    .getAbsolutePath()
        when:
            def command = "score-file --strategy " + strategy + " --csv-file " + file

        then:
            shell.evaluate({ -> command}) == 2927
    }
}
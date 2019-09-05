package com.shrader.namescore.shell.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ResourceLoader
import org.springframework.shell.Shell
import org.springframework.test.context.ContextConfiguration
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


@SpringBootTest(properties = "spring.shell.interactive.enabled=false")
@ContextConfiguration(classes = [ShellControllerConfig.class])
class ShellControllerIntegrationSpec extends Specification {

    @Autowired
    Shell shell

    @Autowired
    ResourceLoader resourceLoader

    @Shared
    def command = "score-file --strategy %s --csv-file %s"


    @Unroll
    def "test score-file command with small file"(String strategy, int expectedScore) {
        given:
            def file = this.resourceLoader
                    .getResource("file:src/main/resources/SmallFile.csv")
                    .getFile()
                    .getAbsolutePath()

        when:
            def score = shell.evaluate({ -> String.format(command, strategy, file)})

        then:
            score == expectedScore

        where:
            strategy | expectedScore
            "first"  | 2927
            "second" | 2927
            "third"  | 2927
    }

    @Unroll
    def "test score-file command with large file"(String strategy, int expectedScore) {
        given:
            def file = this.resourceLoader
                    .getResource("file:src/main/resources/LargeFile.csv")
                    .getFile()
                    .getAbsolutePath()

        when:
            def score = shell.evaluate({ -> String.format(command, strategy, file)})

        then:
            score == expectedScore

        where:
            strategy | expectedScore
            "first"  | 871198282
            "second" | 871198282
            "third"  | 871198282
    }
}
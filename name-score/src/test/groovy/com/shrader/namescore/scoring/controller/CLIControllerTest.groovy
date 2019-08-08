package com.shrader.namescore.scoring.controller

import com.shrader.namescore.controller.CLIController
import com.shrader.namescore.parser.FileLoader
import com.shrader.namescore.parser.FileParser
import com.shrader.namescore.scoring.NameScoreStrategyFactory
import spock.lang.Shared
import spock.lang.Specification

import java.nio.file.Paths


class CLIControllerTest extends Specification {

    @Shared
    def cliController = new CLIController(new FileLoader(), new FileParser(), new NameScoreStrategyFactory())


    def "test score e2e"() {
        given:
            def file = loadFileFromResource("SmallFile.csv")
            def strategy = "FIRST"
            def delimiter = ","
        when:
            def result = cliController.scorefile(file, strategy, delimiter)
        then:
            result == 2927
    }

    def loadFileFromResource(String fileName) throws URISyntaxException {
        def resource = getClass().getClassLoader().getResource(fileName)
        return Paths.get(resource.toURI()).toFile().getAbsolutePath()
    }
}
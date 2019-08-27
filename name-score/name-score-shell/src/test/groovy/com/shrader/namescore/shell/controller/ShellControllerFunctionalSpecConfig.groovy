package com.shrader.namescore.shell.controller

import com.shrader.namescore.scoring.NameScoreStrategyFactory
import com.shrader.namescore.shell.parser.FileLoader
import com.shrader.namescore.shell.parser.NameLoader
import com.shrader.namescore.shell.parser.NameParser
import com.shrader.namescore.shell.parser.StreamParser
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

/**
 * Spring configuration with beans for setting up tests.
 */
@TestConfiguration
class ShellControllerFunctionalSpecConfig {

    @Bean
    NameLoader getNameLoader() {
        return new FileLoader()
    }

    @Bean
    NameParser getNameParser() {
        return new StreamParser()
    }

    @Bean
    NameScoreStrategyFactory getNameScoreStrategyFactory() {
        return new NameScoreStrategyFactory()
    }
}
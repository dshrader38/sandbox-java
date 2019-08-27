package com.shrader.namescore.shell.controller

import com.shrader.namescore.shell.parser.FileLoader
import com.shrader.namescore.shell.parser.NameLoader
import com.shrader.namescore.shell.parser.NameParser
import com.shrader.namescore.shell.parser.StreamParser
import com.shrader.namescore.shell.scoring.NameScoreStrategyFactory
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.shell.Shell

/**
 * Spring configuration with beans for setting up tests.
 */
@TestConfiguration
class ShellControllerIntegrationSpecConfig {

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

    @Bean
    Shell getShell() {
        return new Shell()
    }
}
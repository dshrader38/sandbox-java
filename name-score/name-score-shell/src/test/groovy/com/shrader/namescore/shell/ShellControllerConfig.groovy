package com.shrader.namescore.shell

import com.shrader.namescore.NameScoreAlgorithmFactory
import com.shrader.namescore.shell.parser.FileLoader
import com.shrader.namescore.shell.parser.NameLoader
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean


@TestConfiguration
class ShellControllerConfig {

    @Bean
    NameLoader getNameLoader() {
        return new FileLoader()
    }

    @Bean
    NameScoreAlgorithmFactory getNameScoreStrategyFactory() {
        return new NameScoreAlgorithmFactory()
    }
}
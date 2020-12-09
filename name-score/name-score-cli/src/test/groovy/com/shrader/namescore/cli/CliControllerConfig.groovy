package com.shrader.namescore.cli

import com.shrader.namescore.NameScoreAlgorithmFactory
import com.shrader.namescore.cli.parser.FileLoader
import com.shrader.namescore.cli.parser.NameLoader
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean


@TestConfiguration
class CliControllerConfig {

    @Bean
    NameLoader getNameLoader() {
        return new FileLoader()
    }

    @Bean
    NameScoreAlgorithmFactory getNameScoreStrategyFactory() {
        return new NameScoreAlgorithmFactory()
    }
}
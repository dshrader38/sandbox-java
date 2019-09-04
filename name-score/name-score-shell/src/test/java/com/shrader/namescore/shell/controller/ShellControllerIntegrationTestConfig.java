package com.shrader.namescore.shell.controller;

import com.shrader.namescore.scoring.NameScoreStrategyFactory;
import com.shrader.namescore.shell.parser.FileLoader;
import com.shrader.namescore.shell.parser.NameLoader;
import com.shrader.namescore.shell.parser.NameParser;
import com.shrader.namescore.shell.parser.StreamParser;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;


/**
 * Spring configuration with beans for setting up tests.
 */
@TestConfiguration
public class ShellControllerIntegrationTestConfig {

    @Bean
    public NameLoader getNameLoader() {
        return new FileLoader();
    }

    @Bean
    public NameParser getNameParser() {
        return new StreamParser();
    }

    @Bean
    public NameScoreStrategyFactory getNameScoreStrategyFactory() {
        return new NameScoreStrategyFactory();
    }
}
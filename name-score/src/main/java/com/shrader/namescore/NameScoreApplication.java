package com.shrader.namescore;

import com.shrader.namescore.parse.NameFileParser;
import com.shrader.namescore.scoring.NameScoreStrategyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class NameScoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(NameScoreApplication.class, args);
	}
    
    @Bean
    public NameFileParser fileParser() {
    	NameFileParser fileParser = new NameFileParser();
    	return fileParser;
    }
    
    @Bean
    public NameScoreStrategyFactory nameScoreStrategyFactory() {
    	NameScoreStrategyFactory nameScoreStrategyFactory = new NameScoreStrategyFactory();
    	return nameScoreStrategyFactory;
    }
}

package com.shrader.namescore.controller;

import com.shrader.namescore.parse.FileLoader;
import com.shrader.namescore.parse.FileParser;
import com.shrader.namescore.scoring.NameScoreStrategyFactory;
import com.shrader.namescore.scoring.strategy.NameScoreStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.File;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;


@ConditionalOnProperty(prefix = "app", name = "mode", havingValue = "cli")
@ShellComponent
@Slf4j
public class CLIController {
    private FileLoader fileLoader;
    private FileParser fileParser;
    private NameScoreStrategyFactory nameScoreStrategyFactory;


    public CLIController(FileLoader fileLoader, FileParser fileParser, NameScoreStrategyFactory nameScoreStrategyFactory) {
        this.fileLoader = fileLoader;
        this.fileParser = fileParser;
        this.nameScoreStrategyFactory = nameScoreStrategyFactory;
    }

    @ShellMethod("Score a flat file containing a single line csv of names")
    public int scorefile(@ShellOption() String csvFile,
                         @ShellOption(defaultValue = "BASIC_SCORE") String scoreStrategy,
                         @ShellOption(defaultValue = ",") String delimiter) {
        int result = -1;

        try {
            File file = new File(csvFile);
            if (file.isAbsolute()) {
                throw new IOException("Use a relative path");
            }
            CharBuffer fileData = this.fileLoader.load(file);
            List<String> names = this.fileParser.parse(fileData, delimiter);
            NameScoreStrategy nameScoreStrategy = this.nameScoreStrategyFactory.create(scoreStrategy);
            result = nameScoreStrategy.score(names);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Command failed with exception: " + ex.getMessage());
        }

        return result;
    }
}
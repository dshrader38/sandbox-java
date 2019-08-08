package com.shrader.namescore.controller;

import com.shrader.namescore.parser.FileLoader;
import com.shrader.namescore.parser.FileParser;
import com.shrader.namescore.scoring.NameScoreStrategyFactory;
import com.shrader.namescore.scoring.strategy.NameScoreStrategy;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.CharBuffer;
import java.util.List;


@ConditionalOnProperty(prefix = "app", name = "mode", havingValue = "cli")
@ShellComponent
@Log4j2
public class CLIController {
    private FileLoader fileLoader;
    private FileParser fileParser;
    private NameScoreStrategyFactory nameScoreStrategyFactory;


    public CLIController(FileLoader fileLoader, FileParser fileParser, NameScoreStrategyFactory nameScoreStrategyFactory) {
        this.fileLoader = fileLoader;
        this.fileParser = fileParser;
        this.nameScoreStrategyFactory = nameScoreStrategyFactory;
    }

    @PostConstruct
    public void init() {
        log.info("init");
    }

    @ShellMethod("Score a flat file containing a single line csv of names")
    public int scorefile(@ShellOption() String csvFile,
                         @ShellOption(defaultValue = "FIRST") String strategy,
                         @ShellOption(defaultValue = ",") String delimiter) {
        int result = -1;

        try {
            File file = new File(csvFile);
            //if (file.isAbsolute()) {
            //    throw new IOException("Use a relative path");
            //}
            CharBuffer fileData = this.fileLoader.load(file);
            List<String> names = this.fileParser.parse(fileData, delimiter);
            NameScoreStrategy nameScoreStrategy = this.nameScoreStrategyFactory.create(strategy);
            result = nameScoreStrategy.score(names);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        return result;
    }
}
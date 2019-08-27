package com.shrader.namescore.shell.controller;

import com.shrader.namescore.shell.parser.NameLoader;
import com.shrader.namescore.shell.parser.NameParser;
import com.shrader.namescore.shell.scoring.NameScoreStrategyFactory;
import com.shrader.namescore.shell.scoring.strategy.NameScoreStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.File;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;


@ShellComponent
@ShellCommandGroup("Name Score Commands")
public class ShellController {
    private final Logger log = LogManager.getLogger(getClass().getName());

    private final NameLoader nameLoader;
    private final NameParser nameParser;
    private final NameScoreStrategyFactory nameScoreStrategyFactory;

    @Autowired
    public ShellController(NameLoader nameLoader, NameParser nameParser, NameScoreStrategyFactory nameScoreStrategyFactory) {
        this.nameLoader = nameLoader;
        this.nameParser = nameParser;
        this.nameScoreStrategyFactory = nameScoreStrategyFactory;
    }

    @ShellMethod(value = "Score a flat file containing a single line csv of names")
    public int scoreFile(@ShellOption({"-c", "--csv-file"}) String csvFile,
                         @ShellOption(defaultValue = "FIRST") String strategy,
                         @ShellOption(defaultValue = ",") String delimiter) throws IOException {
        int result = -1;

        try {
            File file = new File(csvFile);
            //if (file.isAbsolute()) {
            //    throw new IOException("Use a relative path");
            //}
            CharBuffer fileData = this.nameLoader.load(file);
            List<String> names = this.nameParser.parse(fileData, delimiter);
            NameScoreStrategy nameScoreStrategy = this.nameScoreStrategyFactory.create(strategy);
            result = nameScoreStrategy.score(names);
        } catch (Exception ex) {
            log.error(ex);

            throw ex;
        }

        return result;
    }

    @ShellMethod(value = "Add two integers")
    public int add(final int a, final int b) {
        return a + b;
    }
}

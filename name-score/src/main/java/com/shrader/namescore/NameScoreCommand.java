package com.shrader.namescore;

import java.io.File;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;

import com.shrader.namescore.parse.NameFileLoader;
import com.shrader.namescore.parse.NameFileParser;
import com.shrader.namescore.scoring.NameScoreStrategyFactory;
import com.shrader.namescore.scoring.strategy.NameScoreStrategy;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;


@ShellComponent
public class NameScoreCommand {
	private NameFileLoader fileLoader;
	private NameFileParser fileParser;
	private NameScoreStrategyFactory nameScoreStrategyFactory;


	public NameScoreCommand(NameFileLoader fileLoader, NameFileParser fileParser, NameScoreStrategyFactory nameScoreStrategyFactory) {
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
			if(file.isAbsolute()) {
				throw new IOException("Use a relative path");
			}
			CharBuffer fileData = this.fileLoader.load(file);
			List<String> names = this.fileParser.parse(fileData, delimiter);
			NameScoreStrategy nameScoreStrategy = this.nameScoreStrategyFactory.createStrategy(scoreStrategy);
			result = nameScoreStrategy.score(names);
		} catch(Exception ex) {
		ex.printStackTrace();
			System.out.println("Command failed with exception: " + ex.getMessage());
		}

		return result;
	}
}
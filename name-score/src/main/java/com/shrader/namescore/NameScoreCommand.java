package com.shrader.namescore;

import java.io.File;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;

import com.shrader.namescore.scoring.NameScoreStrategyFactory;
import com.shrader.namescore.scoring.strategy.NameScoreStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.shrader.namescore.parse.NameLoader;
import com.shrader.namescore.parse.NameFileParser;


@ShellComponent
public class NameScoreCommand {
	private NameLoader fileLoader;
	private NameFileParser fileParser;
	private NameScoreStrategyFactory nameScoreStrategyFactory;

	@Autowired
	public NameScoreCommand(NameLoader fileLoader, NameFileParser fileParser, NameScoreStrategyFactory nameScoreStrategyFactory) {
		this.fileLoader = fileLoader;
		this.fileParser = fileParser;
		this.nameScoreStrategyFactory = nameScoreStrategyFactory;
	}

	/**
	 * This function backs the command line functionality. The required absolute path
	 * is used to identify the file to score. We default the scoringstrategy as well
	 * as the delimiter to the supplied business requirements.
	 * 
	 * @param absoluteFilePath
	 * @return
	 */
	@ShellMethod("Score a flat file containing a single line csv of names")
	public int scorefile(@ShellOption() String absoluteFilePath,
			@ShellOption(defaultValue = "BASIC_SCORE") String scoreStrategy,
			@ShellOption(defaultValue = ",") String nameDelimiter) {
		int totalScore = -1;
		try {
			File file = new File(absoluteFilePath);
			CharBuffer fileData = this.fileLoader.load(file);
			List<String> nameList = this.fileParser.parse(fileData, nameDelimiter);
			NameScoreStrategy nameScoreStrategy = this.nameScoreStrategyFactory.createStrategy(scoreStrategy);
			totalScore = nameScoreStrategy.score(nameList);
		} catch (IOException e) {
			// and print a pretty warning with a -1 response
			e.printStackTrace();
			System.out.println("scorefile command failed with exit code -1");
		}
		return totalScore;
	}
}
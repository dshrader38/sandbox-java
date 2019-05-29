package com.shrader.namescore;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.BeforeClass;
import org.junit.Test;

import com.shrader.namescore.parse.NameFileLoader;
import com.shrader.namescore.parse.NameFileParser;
import com.shrader.namescore.scoring.NameScoreStrategyFactory;

public class NameScoreCommandTest {
	
	private static NameFileLoader fileLoader;
	private static NameFileParser fileParser;
	private static NameScoreStrategyFactory nameScoreStrategyFactory;
	private static NameScoreCommand nameScoreCommand;
	private static String resourceFileName;
	private static long expectedFileScore;

	@BeforeClass
	public static void setup() {
		/**
		 * Should mock these for unit
		 * but using real kills 2 birds w one stone as I will have real e2e flow
		 * and not need to create e2e to ensure it works
		 */
		fileLoader = new NameFileLoader();
		fileParser = new NameFileParser();
		nameScoreStrategyFactory = new NameScoreStrategyFactory();
		resourceFileName = "ShortNameList.csv";
		nameScoreCommand = new NameScoreCommand(fileLoader, fileParser, nameScoreStrategyFactory);
		expectedFileScore = 3194l;
	}
	
	/**
	 * TODO dry; should refactor to helper or 
	 * find an existing helper
	 * @param fileName
	 * @return
	 * @throws URISyntaxException
	 */
	private String testHelper_loadResourceFile(String fileName) throws URISyntaxException {
		URL res = getClass().getClassLoader().getResource(fileName);
		File testFile = Paths.get(res.toURI()).toFile();
		return testFile.getAbsolutePath();
	}

	@Test
	public void testBasicScore() throws URISyntaxException {
		String basicScoreName = "BASIC_SCORE";
		String delimiter = ",";
		String absoluteFilePath = testHelper_loadResourceFile(resourceFileName);

		int result = nameScoreCommand.scorefile(absoluteFilePath, basicScoreName, delimiter);
		assertEquals(expectedFileScore, result);
	}

}

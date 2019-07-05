package com.shrader.namescore.controller;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.BeforeClass;
import org.junit.Test;

import com.shrader.namescore.parse.FileLoader;
import com.shrader.namescore.parse.FileParser;
import com.shrader.namescore.scoring.NameScoreStrategyFactory;


public class CLIControllerTest {
	
	private static FileLoader fileLoader;
	private static FileParser fileParser;
	private static NameScoreStrategyFactory nameScoreStrategyFactory;
	private static CLIController nameScoreCommand;
	private static String resourceFileName;
	private static long expectedFileScore;

	@BeforeClass
	public static void setUp() {
		/**
		 * Should mock these for unit
		 * but using real kills 2 birds w one stone as I will have real e2e flow
		 * and not need to create e2e to ensure it works
		 */
		fileLoader = new FileLoader();
		fileParser = new FileParser();
		nameScoreStrategyFactory = new NameScoreStrategyFactory();
		resourceFileName = "SmallFile.csv";
		nameScoreCommand = new CLIController(fileLoader, fileParser, nameScoreStrategyFactory);
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
		String basicScoreName = "FIRST";
		String delimiter = ",";
		String absoluteFilePath = testHelper_loadResourceFile(resourceFileName);

		int result = nameScoreCommand.scorefile(absoluteFilePath, basicScoreName, delimiter);
		assertEquals(expectedFileScore, result);
	}
}

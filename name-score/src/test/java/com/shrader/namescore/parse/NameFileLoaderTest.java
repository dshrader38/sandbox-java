package com.shrader.namescore.parse;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.CharBuffer;
import java.nio.file.Paths;

import org.junit.BeforeClass;
import org.junit.Test;


/**
 * I don't like to mock file loading during tests
 * as I feel much more confident testing actual resource files
 */
public class NameFileLoaderTest {
	private static String resourceFileName;
	private static NameFileLoader fileLoader;
	private static CharBuffer expectedCharBuffer;

	@BeforeClass
	public static void setUp() {
		fileLoader = new NameFileLoader();
		resourceFileName = "SmallFile.csv";
		String expectedFileData = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\"";
		expectedCharBuffer = CharBuffer.wrap(expectedFileData);
	}
	
	private File testHelper_loadResourceFile(String fileName) throws URISyntaxException {
		URL res = getClass().getClassLoader().getResource(fileName);
		File testFile = Paths.get(res.toURI()).toFile();
		return testFile;
	}

	@Test
	public void test() throws URISyntaxException {
		File testFile = testHelper_loadResourceFile(this.resourceFileName);
		try {
			CharBuffer testDataBuffer = fileLoader.load(testFile);
			assertEquals(expectedCharBuffer, testDataBuffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Expected file not found");
		} catch (IOException e) {
			e.printStackTrace();
			fail("Unexpected IOException");
		}
	}
}

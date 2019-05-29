package com.shrader.namescore.parse;

import static org.junit.Assert.*;

import java.nio.CharBuffer;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;


public class NameFileParserTest {
	private static String delimiter;
	private static char[] expectedChars;
	private static NameFileParser nameFileParser = null;
	private static String[] expectedArray = {
		"\"MARY\"",
		"\"PATRICIA\"",
		"\"LINDA\"",
		"\"BARBARA\"",
		"\"VINCENZO\"",
		"\"SHON\"",
		"\"LYNWOOD\"",
		"\"JERE\"",
		"\"HAI\""
	};

	@BeforeClass
	public static void setup() {
		nameFileParser = new NameFileParser();
		expectedChars = String.join(",", expectedArray).toCharArray();
		delimiter = ",";
	}

	@Test
	public void testCSVData() {
		CharBuffer testDataBuffer = CharBuffer.wrap(expectedChars);
		List<String> parsedList = nameFileParser.parse(testDataBuffer, delimiter);
		assertEquals(expectedArray.length, parsedList.size());
		assertArrayEquals(expectedArray, parsedList.toArray(new String[parsedList.size()]));
	}
	
	public void testEmptyData() {
		char[] emptyData = {};
		CharBuffer testDataBuffer = CharBuffer.wrap(emptyData);
		List<String> parsedList = nameFileParser.parse(testDataBuffer, delimiter);
		assertEquals(emptyData.length, parsedList.size());
	}

}

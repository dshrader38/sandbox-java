package com.shrader.namescore.cli.parser

import spock.lang.Specification


class StreamParserTest extends Specification {

}

/*
package com.shrader.namescore.shell.scoring.parser;

import static org.junit.Assert.*;

import java.nio.CharBuffer;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;


public class StreamParserTest {
    private static String delimiter;
    private static char[] expectedChars;
    private static StreamParser streamParser = null;
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
    public static void setUp() {
        streamParser = new StreamParser();
        expectedChars = String.join(",", expectedArray).toCharArray();
        delimiter = ",";
    }

    @Test
    public void testCSVData() {
        CharBuffer testDataBuffer = CharBuffer.wrap(expectedChars);
        List<String> parsedList = streamParser.parse(testDataBuffer, delimiter);
        assertEquals(expectedArray.length, parsedList.size());
        assertArrayEquals(expectedArray, parsedList.toArray(new String[parsedList.size()]));
    }

    //@Test
    public void testEmptyData() {
        char[] emptyData = {};
        CharBuffer testDataBuffer = CharBuffer.wrap(emptyData);
        List<String> parsedList = streamParser.parse(testDataBuffer, delimiter);
        assertEquals(emptyData.length, parsedList.size());
    }
}
*/
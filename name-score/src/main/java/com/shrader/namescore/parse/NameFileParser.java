package com.shrader.namescore.parse;

import java.nio.CharBuffer;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * TODO refactor 
 * upon reviewing before turning in, I noticed 
 * `•	The company will be switching from first names only to both first and last names in the file.`
 * was not addressed in the best way possible.
 *
 * In the only current implemation of scoring, BasicScoreStrategy
 * I filter characters such as quote, doublequote, and whitspace out.
 * Instead, I should be filtering and mapping here to remove these characters, empty
 * values, and transform names that meet a certain pattern.
 *
 * I have already spent more time on this assignment than I believe I should have been allowed, so I will leave my mistake for discussion.
 */
public class NameFileParser implements NameParser<String> {
	
	/**
	 * Parses a file by a delimiter returning a list of names.
	 * 
	 * @param absoluteFilePath - absolute path to one line csv file to be parsed
	 * @param delimiter - the delimiter to split file data by
	 */
	public List<String> parse(CharBuffer charBuffer, String delimiter) {
		List<String> namesList = Pattern.compile(delimiter)
				.splitAsStream(charBuffer)
				.collect(Collectors.toList());
		return namesList;
	}
}
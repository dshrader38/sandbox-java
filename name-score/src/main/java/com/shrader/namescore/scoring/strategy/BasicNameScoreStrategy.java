package com.shrader.namescore.scoring.strategy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.Streams;
import org.springframework.stereotype.Component;


@Component
public class BasicNameScoreStrategy implements NameScoreStrategy {
	static int characterCodeOffset = 64; // uppercase character codes start at 65, so remove 64
	private static final char SINGLE_QUOTE = '\'';
	private static final char DOUBLE_QUOTE = '"';

	
	@Override
	/**
	 * This method will parse a csv of names, ignoring whitescape and quotes, and scoring a name file
	 * by providing a base score A=1..Z=26 multiplied by the index starting at 1.
	 * 
	 * @param names - list of name strings to parse
	 * @return int - total score of all names in the list
	 */
	public int score(List<String> names) {
		names.sort(Comparator.comparing(Object::toString));

		Stream<String> nameStream = names.stream().map(String::toUpperCase);
		
		/**
		 * Alternatively we could start stream by IntStream.range
		 * and construct a map containing name,index tuples
		 * this would allow our logic to be a little more flexible
		 * and flat
		 */
		Long result = Streams.mapWithIndex(
			nameStream,
			(name, index) -> {
				IntStream nameChars = name.chars();

				int nameValue = nameChars.filter(characterCode -> !Character.isWhitespace(characterCode) && characterCode != DOUBLE_QUOTE  && characterCode != SINGLE_QUOTE)
						.reduce(0, (nameScore, characterCode) -> {
							int characterValue = characterCode - characterCodeOffset;
							return nameScore + characterValue;
						});

				return nameValue * (index+1);
			}
		).reduce(0l, (sum, nameScore) -> sum + nameScore);

		return result.intValue();
	}
}

package com.shrader.namescore.parse;

import java.nio.CharBuffer;
import java.util.List;

/**
 * TODO 
 * 
 * Per the requirement to run in a webapp
 * I would propose we don't ftp and parse files
 * as that involves unnecessary development/maintenance/edge case
 * overhead. We can avoid all this by just buffering
 * the input stream into memory. This avoids many
 * system calls and the like and will have better performance.
 * 
 */
public interface NameParser<A> {
	
	/**
	 * Stream a character buffer and separate names by the supplied delimiter
	 * 
	 * @param dataSource
	 * @param delimiter
	 * @return
	 */
	List<String> parse(CharBuffer dataSource, String delimiter);
}

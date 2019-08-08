package com.shrader.namescore.parser;

import java.nio.CharBuffer;
import java.util.List;


public interface NameParser<A> {

    /**
     * Stream a character buffer and separate names by the supplied delimiter
     *
     * @param dataSource
     * @param delimiter
     * @return List<String>
     */
    List<String> parse(CharBuffer dataSource, String delimiter);
}

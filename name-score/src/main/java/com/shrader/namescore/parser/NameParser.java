package com.shrader.namescore.parser;

import java.nio.CharBuffer;
import java.util.List;


public interface NameParser<T> {

    /**
     * Stream a character buffer and separate names by the supplied delimiter
     *
     * @param dataSource
     * @param delimiter
     * @return List<T>
     */
    List<T> parse(CharBuffer dataSource, String delimiter);
}

package com.shrader.namescore.shell.parser

import java.nio.CharBuffer


interface NameParser<T> {

    /**
     * Stream a character buffer and separate names by the supplied delimiter
     *
     * @param charBuffer
     * @param delimiter
     * @return List<T>
    </T> */
    fun parse(charBuffer: CharBuffer, delimiter: String): List<String>
}

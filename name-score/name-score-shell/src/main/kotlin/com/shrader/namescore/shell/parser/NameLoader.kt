package com.shrader.namescore.shell.parser

import java.io.IOException
import java.nio.CharBuffer


interface NameLoader<T> {
    /**
     * @param dataSource - generic source for the implementation to handle reading data from and into a CharBuffer
     * @return CharBuffer - the implementation must return a CharBuffer in order to effectively decouple logic from data intake
     * @throws IOException - since we are reading from a datasource there is a chance the user could have given us incorrect data/parameters
     */
    @Throws(IOException::class)
    fun load(dataSource: T): CharBuffer
}

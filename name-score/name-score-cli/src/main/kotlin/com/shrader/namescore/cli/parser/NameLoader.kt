package com.shrader.namescore.cli.parser

import java.io.File
import java.io.IOException


interface NameLoader<T> {
    /**
     * @param dataSource - generic source for the implementation to handle reading data from and into a CharBuffer
     * @return List<String> - the implementation must return a List<String> in order to effectively decouple logic from data intake
     * @throws IOException - since we are reading from a datasource there is a chance the user could have given us incorrect data/parameters
     */
    @Throws(IOException::class)
    fun load(dataSource: File, delimiter: String): MutableList<String>
}

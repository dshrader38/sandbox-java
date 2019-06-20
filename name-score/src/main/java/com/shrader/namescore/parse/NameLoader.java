package com.shrader.namescore.parse;

import java.io.IOException;
import java.nio.CharBuffer;


public interface NameLoader<A> {
    /**
     * @param dataSource - generic source for the implementation to handle reading data from and into a CharBuffer
     * @return CharBuffer - the implementation must return a charbuffer in order to effectively decouple logic from data intake
     * @throws IOException - since we are reading from a datasource there is a chance the user could have given us incorrect data/parameters
     */
    CharBuffer load(A dataSource) throws IOException;
}

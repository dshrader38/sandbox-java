package com.shrader.namescore.parse;

import org.springframework.stereotype.Component;

import java.nio.CharBuffer;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Component
public class FileParser implements NameParser<String> {

    public List<String> parse(CharBuffer charBuffer, String delimiter) {
        List<String> namesList = Pattern.compile(delimiter)
                .splitAsStream(charBuffer)
                .collect(Collectors.toList());
        return namesList;
    }
}
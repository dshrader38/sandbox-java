package com.shrader.namescore.shell.scoring.parser;

import org.springframework.stereotype.Component;

import java.nio.CharBuffer;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Component
public class StreamParser implements NameParser<String> {

    @Override
    public List<String> parse(CharBuffer charBuffer, String delimiter) {
        return  Pattern.compile(delimiter)
                .splitAsStream(charBuffer)
                .peek(e -> System.out.println("Original value: " + e))
                .map(e -> e.replaceAll("\"", ""))
                .peek(e -> System.out.println("Mapped value: " + e))
                .map(e -> e.trim())
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }
}
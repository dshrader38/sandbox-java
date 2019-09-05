package com.shrader.namescore.shell.parser

import org.springframework.stereotype.Component
import java.nio.CharBuffer
import java.util.regex.Pattern
import java.util.stream.Stream
import kotlin.streams.toList


@Component
class StreamParser : NameParser<String> {

    override fun parse(charBuffer: CharBuffer, delimiter: String): List<String> {
        val stream: Stream<String> = Pattern.compile(delimiter).splitAsStream(charBuffer)

        return stream
                .peek { println("Original value: $it") }
                .map { it.replace("\"", "") }
                .peek { println("Original value: $it") }
                .map { it.trim() }
                .peek { println("Mapped value: $it") }
                .toList<String>()
    }
}
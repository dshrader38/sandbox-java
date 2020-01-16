package com.shrader.namescore.calculator.parser

import kotlin.streams.toList


class DefaultParser {
    companion object {
        @JvmStatic
        fun parse(names: List<String>): List<String> {

            return names.parallelStream()
                    .peek { println("Original value: $it") }
                    .map { it.replace("\"", "") }
                    .peek { println("Original value: $it") }
                    .map { it.trim() }
                    .peek { println("Mapped value: $it") }
                    .toList<String>()
        }
    }
}
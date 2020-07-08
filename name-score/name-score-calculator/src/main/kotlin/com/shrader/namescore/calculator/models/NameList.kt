package com.shrader.namescore.calculator.models


class NameList(var names: MutableList<String>) {

    init {
        println("First initializer block")
    }

    fun scrub() {
        names.stream()
                .peek { println("Original value: $it") }
                .map { it.replace("\"", "") }
                .peek { println("Original value: $it") }
                .map { it.trim() }
                .peek { println("Mapped value: $it") }
    }
}
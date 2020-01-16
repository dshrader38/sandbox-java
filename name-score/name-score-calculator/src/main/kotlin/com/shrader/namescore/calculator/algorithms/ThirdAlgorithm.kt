package com.shrader.namescore.calculator.algorithms

import com.shrader.namescore.calculator.NameScoreAlgorithm
import org.springframework.stereotype.Component
import java.util.stream.LongStream


@Component
internal class ThirdAlgorithm : NameScoreAlgorithm {

    companion object {
        private const val BASE = 'A'.toInt()
    }

    override fun score(names: List<String>): Long {
        var result = 0L

        if (names.isNotEmpty()) {
            val sortedNames = names.toMutableList()
            sortedNames.sort()

            result = LongStream.range(0L, sortedNames.size.toLong()).parallel()
                    .map { scoreName(sortedNames[it.toInt()], it + 1) }
                    .sum()
        }

        return result
    }

    private fun scoreName(name: String, multiplier: Long): Long {
        var result: Long = 0

        for (character in name) {
            val value = character.toInt()
            result += value - BASE + 1
        }

        return result * multiplier
    }
}

package com.shrader.namescore.calculator.algorithms

import com.shrader.namescore.calculator.NameScoreAlgorithm
import org.springframework.stereotype.Component
import java.util.stream.IntStream


@Component
internal class ThirdAlgo : NameScoreAlgorithm {

    companion object {
        private const val BASE = 'A'.toInt()
    }

    override fun score(names: List<String>): Int {
        if(names.isEmpty()) {
            return 0
        }

        val sortedNames = names.sortedWith(String.CASE_INSENSITIVE_ORDER)

        return IntStream.range(0, sortedNames.size).parallel()
                .map {scoreName(sortedNames[it], it + 1) }
                .sum()
    }

    private fun scoreName(name: String, multiplier: Int): Int {
        var result = 0

        for (character in name) {
            val value = character.toInt()
            result += value - BASE + 1
        }

        return result * multiplier
    }
}

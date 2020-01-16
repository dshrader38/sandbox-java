package com.shrader.namescore.calculator.algorithms

import com.shrader.namescore.calculator.NameScoreAlgorithm
import org.springframework.stereotype.Component


@Component
internal class FirstAlgorithm : NameScoreAlgorithm {

    companion object {
        private const val BASE = 'A'.toInt()
    }

    override fun score(names: List<String>): Long {
        var result = 0L

        if (names.isNotEmpty()) {
            // list needs to be mutable...and use a natural sort
            val sortedNames = names.toMutableList()
            sortedNames.sort()

            for (i in sortedNames.indices) {
                val name = sortedNames[i]

                result += scoreName(name, i + 1)
            }
        }

        return result
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

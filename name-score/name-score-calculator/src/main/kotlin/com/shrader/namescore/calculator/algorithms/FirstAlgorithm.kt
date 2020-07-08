package com.shrader.namescore.calculator.algorithms

import com.shrader.namescore.calculator.NameScoreAlgorithm
import org.springframework.stereotype.Component


@Component
internal class FirstAlgorithm : NameScoreAlgorithm {

    companion object {
        private const val CHARACTER_OFFSET = 64
    }

    override fun score(names: MutableList<String>): Long {
        var result: Long = 0

        if (names.isEmpty())
            return result

        // use a natural sort
        names.sort()

        for (i in names.indices) {
            result += scoreName(names[i], i + 1)
        }

        return result
    }

    private fun scoreName(name: String, multiplier: Int): Int {
        var result: Int = 0

        for (c in name) {
            if (c.toInt() in 65..90) {
                val value = c.toInt() - CHARACTER_OFFSET
                result += value
            }
        }

        return result * multiplier
    }
}

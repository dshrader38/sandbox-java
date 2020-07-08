package com.shrader.namescore.calculator.algorithms

import com.shrader.namescore.calculator.NameScoreAlgorithm
import org.springframework.stereotype.Component
import java.util.stream.LongStream


@Component
internal class ThirdAlgorithm : NameScoreAlgorithm {

    companion object {
        private const val CHARACTER_OFFSET = 64
    }

    override fun score(names: MutableList<String>): Long {
        var result: Long = 0

        if (names.isEmpty())
            return result

        // use a natural sort
        names.sort()

        result = LongStream.range(0, names.size.toLong())
                .map { scoreName(names[it.toInt()], it + 1) }
                .sum()

        return result
    }

    private fun scoreName(name: String, multiplier: Long): Long {
        val result = name.chars().map{ if (it in 65..90) it - CHARACTER_OFFSET else 0 }.sum()

        return result * multiplier
    }
}

package com.shrader.namescore.scoring.strategy

import com.shrader.namescore.scoring.NameScoreStrategy
import org.springframework.stereotype.Component
import java.util.stream.IntStream


@Component
class ThirdNameScoreStrategy : NameScoreStrategy {

    companion object {
        private const val BASE = 'A'.toInt()
    }

    override fun score(names: List<String>): Int {
        if(names.isEmpty()) {
            return 0
        }

        val sortedNames = names.sortedWith(String.CASE_INSENSITIVE_ORDER)

        return IntStream.range(0, sortedNames.size).parallel()
                .map { i -> scoreName(sortedNames[i], i + 1) }
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

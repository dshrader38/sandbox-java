package com.shrader.namescore.scoring.strategy

import com.shrader.namescore.scoring.NameScoreStrategy
import org.springframework.stereotype.Component


@Component
class FirstNameScoreStrategy : NameScoreStrategy {

    companion object {
        private const val BASE = 'A'.toInt()
    }

    override fun score(names: List<String>): Int {
        if(names.isEmpty()) {
            return 0
        }

        var sortedNames = names.toMutableList()
        sortedNames.sort()

        var result = 0
        for (i in sortedNames.indices) {
            val name = sortedNames[i]

            result += scoreName(name, i + 1)
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

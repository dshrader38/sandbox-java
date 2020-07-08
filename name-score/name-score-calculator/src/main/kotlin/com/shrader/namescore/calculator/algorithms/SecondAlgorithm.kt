package com.shrader.namescore.calculator.algorithms

import com.google.common.collect.Streams
import com.shrader.namescore.calculator.NameScoreAlgorithm
import org.springframework.stereotype.Component


@Component
internal class SecondAlgorithm : NameScoreAlgorithm {

    companion object {
        private const val CHARACTER_OFFSET = 64
    }

    /**
     * This method will parse a csv of names, ignoring whitescape and quotes, and scoring a name file
     * by providing a base score A=1..Z=26 multiplied by the index starting at 1.
     *
     * @param names - list of name strings to parse
     * @return int - total score of all names in the list
     */
    override fun score(names: MutableList<String>): Long {
        var result: Long = 0

        if (names.isEmpty())
            return result

        // use a natural sort
        names.sort()

        val stream = names.map { it.toUpperCase() }.stream()

        /**
         * Alternatively we could start stream by IntStream.range
         * and construct a map containing name, index tuples
         * this would allow our logic to be a little more flexible
         * and flat
         */
        result = Streams.mapWithIndex<String, Long>(stream) { name, index ->
            val value = name
                    .chars()
                    .reduce(0) { score, character ->
                        score + character - CHARACTER_OFFSET
                    }

            (value * (index + 1))
        }.reduce(0L) { sum, nameScore ->
            sum!! + nameScore!!
        }

        return result
    }

    /*
    private fun scoreName(name: String, multiplier: Int): Int {
        var result = 0

        for (character in name) {
            val value = character.toInt() % characterOffset + 1
            result += value
        }

        return result * multiplier
    }
    */
}

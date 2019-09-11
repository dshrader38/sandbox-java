package com.shrader.namescore.calculator.algorithms

import com.google.common.collect.Streams
import com.shrader.namescore.calculator.NameScoreAlgorithm
import org.springframework.stereotype.Component


@Component
internal class SecondAlgo : NameScoreAlgorithm {

    companion object {
        internal var characterOffset = 64 // uppercase character codes start at 65, so remove 64
    }

    /**
     * This method will parse a csv of names, ignoring whitescape and quotes, and scoring a name file
     * by providing a base score A=1..Z=26 multiplied by the index starting at 1.
     *
     * @param names - list of name strings to parse
     * @return int - total score of all names in the list
     */
    override fun score(names: List<String>): Int {
        if (names.isEmpty()) {
            return 0
        }

        val sortedNames = names.sortedWith(String.CASE_INSENSITIVE_ORDER)

        val stream = sortedNames.map { it.toUpperCase() }.stream()
        /**
         * Alternatively we could start stream by IntStream.range
         * and construct a map containing name,index tuples
         * this would allow our logic to be a little more flexible
         * and flat
         */
        val result = Streams.mapWithIndex<String, Long>(stream) { name, index ->
            val result = name
                    .chars()
                    .reduce(0) { score, character ->
                        score + character - characterOffset
                    }

            (result * (index + 1))
        }.reduce(0L) { sum, nameScore ->
            sum!! + nameScore!!
        }

        return result!!.toInt()
    }
}

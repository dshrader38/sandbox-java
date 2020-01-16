package com.shrader.namescore.computation.algorithms

import com.shrader.namescore.calculator.algorithms.SecondAlgorithm
import spock.lang.Unroll


class SecondAlgorithmSpec extends DefaultParserSpec {

    @Unroll
    def "Test 2nd strategy"(ArrayList<String> nameList, int expectedScore) {
        given:
            def strategy = new SecondAlgorithm()

        when:
            def score = strategy.score(nameList)

        then:
            score == expectedScore

        where:
            nameList            | expectedScore
            emptyNameList       | 0
            singleNameList      | 40
            multipleNameList    | 2927
            multipleBadNameList | 637
    }
}
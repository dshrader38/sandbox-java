package com.shrader.namescore.computation.algorithms

import com.shrader.namescore.calculator.algorithms.ThirdAlgorithm
import spock.lang.Unroll


class ThirdAlgorithmSpec extends DefaultParserSpec {

    @Unroll
    def "Test 3rd strategy"(ArrayList<String> nameList, int expectedScore) {
        given:
            def strategy = new ThirdAlgorithm()

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
package com.shrader.namescore.computation.algorithms

import com.shrader.namescore.calculator.algorithms.FirstAlgorithm
import spock.lang.Unroll


class FirstAlgorithmSpec extends DefaultParserSpec {

    @Unroll
    def "Test 1st strategy"(ArrayList<String> nameList, int expectedScore) {
        given:
            def strategy = new FirstAlgorithm()

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
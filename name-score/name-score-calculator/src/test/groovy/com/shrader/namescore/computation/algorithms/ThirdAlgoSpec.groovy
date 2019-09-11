package com.shrader.namescore.computation.algorithms

import com.shrader.namescore.calculator.algorithms.ThirdAlgo
import spock.lang.Unroll


class ThirdAlgoSpec extends BaseAlgoSpec {

    @Unroll
    def "Test 3rd strategy"(ArrayList<String> nameList, int expectedScore) {
        given:
            def strategy = new ThirdAlgo()

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
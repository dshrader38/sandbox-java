package com.shrader.namescore.computation.algorithms

import com.shrader.namescore.calculator.algorithms.SecondAlgo
import spock.lang.Unroll


class SecondAlgoSpec extends BaseAlgoSpec {

    @Unroll
    def "Test 2nd strategy"(ArrayList<String> nameList, int expectedScore) {
        given:
            def strategy = new SecondAlgo()

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
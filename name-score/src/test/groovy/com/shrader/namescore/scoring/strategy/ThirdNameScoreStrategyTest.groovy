package com.shrader.namescore.scoring.strategy

import spock.lang.Shared
import spock.lang.Unroll


class ThirdNameScoreStrategyTest extends BaseNameScoreStrategyTest {

    @Unroll
    def "Test 3rd strategy"(ArrayList<String> nameList, int expectedScore) {
        given:
            def strategy = new ThirdNameScoreStrategy()

        when:
            def score = strategy.score(nameList)

        then:
            score == expectedScore

        where:
            nameList | expectedScore
            emptyNameList  | 0
            singleNameList | 40
            multipleNameList  | 2927
            multipleBadNameList  | 637
    }
}
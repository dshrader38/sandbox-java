package com.shrader.namescore.scoring.strategy

import spock.lang.Unroll


class FirstNameScoreStrategyTest extends BaseNameScoreStrategyTest {

    @Unroll
    def "Test 1st strategy"(ArrayList<String> nameList, int expectedScore) {
        given:
            def strategy = new FirstNameScoreStrategy()

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
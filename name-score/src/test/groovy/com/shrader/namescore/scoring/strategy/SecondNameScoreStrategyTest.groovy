package com.shrader.namescore.scoring.strategy

import spock.lang.Unroll


class SecondNameScoreStrategyTest extends BaseNameScoreStrategyTest {

    @Unroll
    def "Test 2nd strategy"(ArrayList<String> nameList, int expectedScore) {
        given:
            def strategy = new SecondNameScoreStrategy()

        when:
            def score = strategy.score(nameList)

        then:
            score == expectedScore

        where:
            nameList | expectedScore
            emptyNameList  | 0
            singleNameList | 40
            multipleNameList  | 2927
            multipleBadNameList  | 637 // 4027
    }
}
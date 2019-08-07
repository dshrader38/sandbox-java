package com.shrader.namescore.scoring.strategy

import com.shrader.namescore.scoring.strategy.SecondNameScoreStrategy
import spock.lang.Shared
import spock.lang.Specification


class SecondNameScoreStrategyTest extends Specification {

    @Shared
    def secondNameScoreStrategy = new SecondNameScoreStrategy()

    @Shared
    def emptyNameList = new ArrayList<String>()

    @Shared
    def singleNameList = ["DAVID"]

    @Shared
    def multipleNameList = ["JIMMY", "MICHAEL\"", "\"DAVID\"", "TIMMY", "SARA", "AMANDA",
                            "", " ", "\"\"", "\"", "KYLE", "MJ", "LUCY"]

    def "Test 2nd strategy using empty list as input"() {
        when:
            def result = secondNameScoreStrategy.score(emptyNameList)
        then:
            result == 0
    }

    def "Test 2nd strategy using list with single name as input"() {
        when:
            def result = secondNameScoreStrategy.score(singleNameList)
        then:
            result == 40
    }

    def "Test 2nd strategy using list with multiple names as input"() {
        when:
            def result = secondNameScoreStrategy.score(multipleNameList)
        then:
            result == 3144 // 4138
    }
}
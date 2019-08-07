package com.shrader.namescore.scoring.strategy

import com.shrader.namescore.scoring.strategy.ThirdNameScoreStrategy
import spock.lang.Shared
import spock.lang.Specification


class ThirdNameScoreStrategyTest extends Specification {

    @Shared
    def thirdNameScoreStrategy = new ThirdNameScoreStrategy()

    @Shared
    def emptyNameList = new ArrayList<String>()

    @Shared
    def singleNameList = ["DAVID"]

    @Shared
    def multipleNameList = ["JIMMY", "MICHAEL\"", "\"DAVID\"", "TIMMY", "SARA", "AMANDA",
                            "", " ", "\"\"", "\"", "KYLE", "MJ", "LUCY"]

    def "Test 3rd strategy using empty list as input"() {
        when:
            def result = thirdNameScoreStrategy.score(emptyNameList)
        then:
            result == 0
    }

    def "Test 3rd strategy using list with single name as input"() {
        when:
            def result = thirdNameScoreStrategy.score(singleNameList)
        then:
            result == 40
    }

    def "Test 3rd strategy using list with multiple names as input"() {
        when:
            def result = thirdNameScoreStrategy.score(multipleNameList)
        then:
            result == 3144
    }
}
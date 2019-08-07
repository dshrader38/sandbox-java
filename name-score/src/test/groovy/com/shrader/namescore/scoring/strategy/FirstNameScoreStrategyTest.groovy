package com.shrader.namescore.scoring.strategy

import spock.lang.Shared
import spock.lang.Specification


class FirstNameScoreStrategyTest extends Specification {

    @Shared
    def firstNameScoreStrategy = new FirstNameScoreStrategy()

    @Shared
    def emptyNameList = new ArrayList<String>()

    @Shared
    def singleNameList = ["DAVID"]

    @Shared
    def multipleNameList = ["JIMMY", "MICHAEL\"", "\"DAVID\"", "TIMMY", "SARA", "AMANDA",
                            "", " ", "\"\"", "\"", "KYLE", "MJ", "LUCY"]

    def "Test 1st strategy using empty list as input"() {
        when:
            def result = firstNameScoreStrategy.score(emptyNameList)
        then:
            result == 0
    }

    def "Test 1st strategy using list with single name as input"() {
        when:
            def result = firstNameScoreStrategy.score(singleNameList)
        then:
            result == 40
    }

    def "Test 1st strategy using list with multiple names as input"() {
        when:
            def result = firstNameScoreStrategy.score(multipleNameList)
        then:
            result == 3144
    }
}
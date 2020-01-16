package com.shrader.namescore.computation

import com.shrader.namescore.NameScoreAlgorithmFactory
import com.shrader.namescore.calculator.NameScoreAlgorithm
import com.shrader.namescore.calculator.algorithms.FirstAlgorithm
import com.shrader.namescore.calculator.algorithms.SecondAlgorithm
import com.shrader.namescore.calculator.algorithms.ThirdAlgorithm
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


class NameScoreAlgorithmFactorySpec extends Specification {

    @Shared
    def nameScoreStrategyFactory = new NameScoreAlgorithmFactory()


    @Unroll
    def "test third name-score strategy factory"(String strategy, Class<? extends NameScoreAlgorithm> expectedClass) {
        when:
            def nameScoreStrategy = nameScoreStrategyFactory.create(strategy)
        then:
            nameScoreStrategy in expectedClass
        where:
            strategy | expectedClass
            "first"  | FirstAlgorithm
            "second" | SecondAlgorithm
            "third"  | ThirdAlgorithm
    }

    def "test unknown name score strategy factory"() {
        when:
            nameScoreStrategyFactory.create("")
        then:
            def ex = thrown IllegalArgumentException
            ex.message == "Please enter a valid strategy!"
    }
}

package com.shrader.namescore.scoring

import com.shrader.namescore.scoring.strategy.FirstNameScoreStrategy
import com.shrader.namescore.scoring.strategy.NameScoreStrategy
import com.shrader.namescore.scoring.strategy.SecondNameScoreStrategy
import com.shrader.namescore.scoring.strategy.ThirdNameScoreStrategy
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


class NameScoreStrategyFactoryTest extends Specification {

    @Shared
    def nameScoreStrategyFactory = new NameScoreStrategyFactory()


    @Unroll
    def "test third name-score strategy factory"(String strategy, Class<? extends NameScoreStrategy> expectedClass) {
        when:
            def nameScoreStrategy = nameScoreStrategyFactory.create(strategy)
        then:
            nameScoreStrategy in expectedClass
        where:
            strategy | expectedClass
            "first"  | FirstNameScoreStrategy
            "second" | SecondNameScoreStrategy
            "third"  | ThirdNameScoreStrategy
    }

    def "test unknown name score strategy factory"() {
        when:
            nameScoreStrategyFactory.create("")
        then:
            def ex = thrown IllegalArgumentException
            ex.message == "Please enter a valid strategy!"
    }
}

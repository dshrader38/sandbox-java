package namescore.scoring;

import com.shrader.namescore.scoring.NameScoreStrategyFactory
import com.shrader.namescore.scoring.strategy.PrimaryNameScoreStrategy
import com.shrader.namescore.scoring.strategy.SecondaryNameScoreStrategy
import com.shrader.namescore.scoring.strategy.TertiaryNameScoreStrategy
import spock.lang.Shared
import spock.lang.Specification

import static org.hamcrest.CoreMatchers.instanceOf


class NameScoreStrategyFactoryTest extends Specification {

	@Shared def nameScoreStrategyFactory = new NameScoreStrategyFactory()


	def "test primary name score strategy factory"() {
		given:
			println "\n*** run with data for missing instrument ***\n"
			def result = nameScoreStrategyFactory.create("PRIMARY")
		expect:
			result == instanceOf(PrimaryNameScoreStrategy.class)
	}

	def "test secondary name score strategy factory"() {
		given:
			def result = nameScoreStrategyFactory.create("SECONDARY")
		expect:
			result == instanceOf(SecondaryNameScoreStrategy.class)
	}

	def "test tertiary name score strategy factory"() {
		given:
			def result = nameScoreStrategyFactory.create("TERTIARY")
		expect:
			result == instanceOf(TertiaryNameScoreStrategy.class)
	}
}


//void testDefaultStrategy() {
//	NameScoreStrategy result = nameScoreStrategyFactory.create("");
//	assert(result, instanceOf(PRIMARY.class));
//}

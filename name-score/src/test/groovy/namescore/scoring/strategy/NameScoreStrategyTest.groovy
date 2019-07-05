package namescore.scoring.strategy

import com.shrader.namescore.scoring.strategy.FirstNameScoreStrategy
import com.shrader.namescore.scoring.strategy.SecondNameScoreStrategy
import com.shrader.namescore.scoring.strategy.ThirdNameScoreStrategy
import spock.lang.Shared
import spock.lang.Specification


class NameScoreStrategyTest extends Specification {

    def firstNameScoreStrategy = new FirstNameScoreStrategy()

    @Shared
    def singleNameList = ["DAVID"]

    @Shared
    def multipleNameList = ["MARY", "PATRICIA\"", "\"LINDA\"", "BARBARA", "VINCENZO", "SHON",
                            "", " ", "\"\"", "\"", "LYNWOOD", "JERE", "HAI"]

    /*
	@Test
	public void testBasicNameScoreStrategyEmptyList() {
		int result = basicNameScoreStrategy.score(new ArrayList<>());
		Assert.assertEquals(0l, result);
	}

    @Test
    public void testBetterNameScoreStrategyEmptyList() {
        int result = betterNameScoreStrategy.score(new ArrayList<>());
        Assert.assertEquals(0l, result);
    }

    @Test
    public void testBasicNameScoreStrategySingleNameList() {
        int result = basicNameScoreStrategy.score(singleNameList);
        Assert.assertEquals(40, result);
    }

    @Test
    public void testBetterNameScoreStrategySingleNameList() {
        int result = betterNameScoreStrategy.score(singleNameList);
        Assert.assertEquals(40, result);
    }

	@Test
	public void testBasicNameScoreStrategyList() {
		int result = basicNameScoreStrategy.score(multipleNameList);
		Assert.assertEquals(5332, result);
	}

    @Test
    public void testBetterNameScoreStrategyList() {
        int result = betterNameScoreStrategy.score(multipleNameList);
        Assert.assertEquals(4128, result);
    }
    */
}
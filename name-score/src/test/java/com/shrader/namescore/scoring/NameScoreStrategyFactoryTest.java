package com.shrader.namescore.scoring;

import com.shrader.namescore.scoring.strategy.SecondaryNameScoreStrategy;
import com.shrader.namescore.scoring.strategy.NameScoreStrategy;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;


public class NameScoreStrategyFactoryTest {
	private static NameScoreStrategyFactory nameScoreStrategyFactory;

	@BeforeClass
	public static void setUp() {
		nameScoreStrategyFactory = new NameScoreStrategyFactory();
	}

	@Test
	public void testDefaultStrategy() {
		//NameScoreStrategy defaultScoreStrategy = nameScoreStrategyFactory.createStrategy("");
        //assertThat(defaultScoreStrategy, instanceOf(BasicNameScoreStrategy.class));
	}
	
	@Test
	public void testBasicStoreStrategy() {
		NameScoreStrategy result = nameScoreStrategyFactory.createStrategy("BASIC_SCORE");
        assertThat(result, instanceOf(SecondaryNameScoreStrategy.class));
	}
}

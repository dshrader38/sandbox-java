package com.shrader.namescore.scoring;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.shrader.namescore.scoring.strategy.BasicNameScoreStrategy;
import com.shrader.namescore.scoring.strategy.NameScoreStrategy;


public class NameScoreStrategyFactoryTest {
	
	private static NameScoreStrategyFactory nameScoreStrategyFactory;

	@BeforeClass
	public static void setup() {
		nameScoreStrategyFactory = new NameScoreStrategyFactory();
	}

	@Test
	public void testDefaultStrategy() {
		NameScoreStrategy defaultScoreStrategy = nameScoreStrategyFactory.createStrategy("");
        assertThat(defaultScoreStrategy, instanceOf(BasicNameScoreStrategy.class));
	}
	
	@Test
	public void testBasicStoreStrategy() {
		NameScoreStrategy basicScoreStrategy = nameScoreStrategyFactory.createStrategy("BASIC_SCORE");
        assertThat(basicScoreStrategy, instanceOf(BasicNameScoreStrategy.class));
	}

}

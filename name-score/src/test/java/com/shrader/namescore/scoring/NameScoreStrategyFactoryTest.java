/*
package com.shrader.namescore.scoring;

import com.shrader.namescore.scoring.strategy.PrimaryNameScoreStrategy;
import com.shrader.namescore.scoring.strategy.SecondaryNameScoreStrategy;
import com.shrader.namescore.scoring.strategy.NameScoreStrategy;
import com.shrader.namescore.scoring.strategy.TertiaryNameScoreStrategy;
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
	public void testPrimaryStoreStrategy() {
		NameScoreStrategy result = nameScoreStrategyFactory.create("PRIMARY");
        assertThat(result, instanceOf(PrimaryNameScoreStrategy.class));
	}

	@Test
	public void testSecondaryStoreStrategy() {
		NameScoreStrategy result = nameScoreStrategyFactory.create("SECONDARY");
		assertThat(result, instanceOf(SecondaryNameScoreStrategy.class));
	}

	@Test
	public void testTertiaryStoreStrategy() {
		NameScoreStrategy result = nameScoreStrategyFactory.create("TERTIARY");
		assertThat(result, instanceOf(TertiaryNameScoreStrategy.class));
	}

	@Test
	public void testDefaultStrategy() {
		NameScoreStrategy result = nameScoreStrategyFactory.create("");
		assert(result, instanceOf(PRIMARY.class));
	}
}
*/
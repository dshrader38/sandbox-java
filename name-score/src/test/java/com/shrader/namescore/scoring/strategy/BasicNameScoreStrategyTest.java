package com.shrader.namescore.scoring.strategy;

import java.util.ArrayList;

import com.shrader.namescore.scoring.strategy.BasicNameScoreStrategy;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

class BasicScoreTest {
	static BasicNameScoreStrategy basicScore;
	
	@BeforeClass
	static void setUp() {
		basicScore = new BasicNameScoreStrategy();
	}
	
	static ArrayList<String> testNames = new ArrayList<String>();
	static {
		testNames.add("\"MARY");
		testNames.add("PATRICIA\"");
		testNames.add("\"LINDA\"");
		testNames.add("BARBARA");
		testNames.add("VINCENZO");
		testNames.add("SHON");
		testNames.add("");
		testNames.add(" ");
		testNames.add("\"\"");
		testNames.add("\"");
		testNames.add("LYNWOOD");
		testNames.add("JERE");
		testNames.add("HAI");
	}
	
	@Test
	void testEmptyList() {
		int basicScoreResult = basicScore.score(new ArrayList<String>());
		Assert.assertEquals(0l, basicScoreResult);
	}
	
	@Test
	void testBasicList() {
		int basicScoreResult = basicScore.score(testNames);

		int expectedScore = 3194;
		Assert.assertEquals(expectedScore, basicScoreResult);
	}

}

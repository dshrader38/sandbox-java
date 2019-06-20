package com.shrader.namescore.scoring.strategy;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;


public class NameScoreStrategyTest {
	private static SecondaryNameScoreStrategy basicNameScoreStrategy;
    private static TertiaryNameScoreStrategy betterNameScoreStrategy;

    private static ArrayList<String> singleNameList = new ArrayList<>();
    static {
        singleNameList.add("DAVID");
    }

    private static ArrayList<String> multipleNameList = new ArrayList<>();
    static {
        multipleNameList.add("\"MARY");
        multipleNameList.add("PATRICIA\"");
        multipleNameList.add("\"LINDA\"");
        multipleNameList.add("BARBARA");
        multipleNameList.add("VINCENZO");
        multipleNameList.add("SHON");
        multipleNameList.add("");
        multipleNameList.add(" ");
        multipleNameList.add("\"\"");
        multipleNameList.add("\"");
        multipleNameList.add("LYNWOOD");
        multipleNameList.add("JERE");
        multipleNameList.add("HAI");
    }

    @BeforeClass
	public static void setUp() {
		basicNameScoreStrategy = new SecondaryNameScoreStrategy();
        betterNameScoreStrategy = new TertiaryNameScoreStrategy();
	}

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
}
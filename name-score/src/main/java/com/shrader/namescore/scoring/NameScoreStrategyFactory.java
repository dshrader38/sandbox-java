package com.shrader.namescore.scoring;

import java.util.HashMap;
import java.util.Map;

import com.shrader.namescore.scoring.strategy.BasicNameScoreStrategy;
import com.shrader.namescore.scoring.strategy.BetterNameScoreStrategy;
import com.shrader.namescore.scoring.strategy.NameScoreStrategy;


public class NameScoreStrategyFactory {
	
	private enum NameScoreStrategyName
	{
	    BASIC_SCORE("BASIC_SCORE"),
		BETTER_SCORE("BETTER_SCORE");

	    private String strategyName;
	    private static final Map<String, NameScoreStrategyName> nameStringToEnum = new HashMap<>();
	 
		NameScoreStrategyName(String strategyName) {
	        this.strategyName = strategyName;
	    }
	 
	    public String getStrategyName() {
	        return this.strategyName;
	    }
	    
	    static {
	        for(NameScoreStrategyName strategyName : NameScoreStrategyName.values()) {
	        	nameStringToEnum.put(strategyName.getStrategyName(), strategyName);
	        }
	    }
	  
	    public static NameScoreStrategyName get(String strategyName) {
	    	NameScoreStrategyName nameScoreStrategyName = nameStringToEnum.get(strategyName);
	        return (nameScoreStrategyName != null)
	        		? nameScoreStrategyName
	        		: BASIC_SCORE;
	    }
	}

	/**
	 * Takes a string identifying which scoring algorithm to use
	 * and returns a Strategy containing the logic for this algorithm.
	 * 
	 * If an incorrect identifier is given, the factory returns the default BASIC_SCORE strategy
	 * 
	 * @param strategyName
	 * @return
	 */
	public NameScoreStrategy createStrategy(String strategyName) {
		NameScoreStrategyName nameScoreStrategyName = NameScoreStrategyName.get(strategyName);

		NameScoreStrategy strategyInstance = null;
		switch(nameScoreStrategyName) {
			case BASIC_SCORE:
				strategyInstance = new BasicNameScoreStrategy();
				break;
			case BETTER_SCORE:
				strategyInstance = new BetterNameScoreStrategy(null);
				break;
			default:
				// TODO this should never exec since enum defaults
				// but better safe than sorry
				// reviewers might want me to stop defaulting
				// enum as that might be weird to others
				// and rather just default here
				// I thought it acceptable as the enum was mapping
				// with user input which is not compile time checked
				strategyInstance = new BasicNameScoreStrategy();
				break;
		}

		return strategyInstance;
	}
}

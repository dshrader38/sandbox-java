package com.shrader.namescore.scoring;

import java.util.HashMap;
import java.util.Map;

import com.shrader.namescore.scoring.strategy.PrimaryNameScoreStrategy;
import com.shrader.namescore.scoring.strategy.SecondaryNameScoreStrategy;
import com.shrader.namescore.scoring.strategy.TertiaryNameScoreStrategy;
import com.shrader.namescore.scoring.strategy.NameScoreStrategy;


public class NameScoreStrategyFactory {
	
	private enum NameScoreStrategyName
	{
		PRIMARY("PRIMARY"),
	    SECONDARY("SECONDARY"),
		TERTIARY("TERTIARY");

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
	  
	    public static NameScoreStrategyName get(String name) {
	    	NameScoreStrategyName result = nameStringToEnum.get(name.toUpperCase());
	    	if (result == null) {
				throw new IllegalArgumentException("Please enter a valid strategy!");
			}

			return result;
	    }
	}

	/**
	 * Takes a string identifying which scoring algorithm to use
	 * and returns a Strategy containing the logic for this algorithm.
	 * 
	 * If an incorrect identifier is given, the factory returns the default BASIC_SCORE strategy
	 * 
	 * @param name
	 * @return
	 */
	public NameScoreStrategy createStrategy(String name) {
		NameScoreStrategy result;

		NameScoreStrategyName nameScoreStrategyName = NameScoreStrategyName.get(name);
		switch(nameScoreStrategyName) {
			case PRIMARY:
				result = new PrimaryNameScoreStrategy();
				break;
			case SECONDARY:
				result = new SecondaryNameScoreStrategy();
				break;
			case TERTIARY:
				result = new TertiaryNameScoreStrategy();
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + nameScoreStrategyName);
		}

		return result;
	}
}

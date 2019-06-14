package com.shrader.namescore.scoring.strategy;

import java.util.List;


public interface NameScoreStrategy {

	/**
	 * 
	 * @param names - list of name strings to parse
	 * @return int - total score of all names in the list
	 */
	int score(List<String> names);
}

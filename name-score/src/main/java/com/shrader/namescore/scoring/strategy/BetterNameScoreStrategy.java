package com.shrader.namescore.scoring.strategy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;


public class BetterNameScoreStrategy implements NameScoreStrategy {

    private static final char BASE = 'A';
    private final Comparator<String> comparator;


    public BetterNameScoreStrategy(final Comparator<String> comparator) {
        this.comparator = comparator;
    }


    @Override
    public int score(List<String> names) {
        List<String> sortedNames = prepare(names);

        int score = IntStream.range(0, names.size()).parallel()
                .map(i -> scoreName(sortedNames.get(i), i+1))
                .sum();

        return score;
    }


    private List<String> prepare(List<String> names) {
        names.sort(comparator);
        return names;
    }


    private int scoreName(String name, int multiplier) {
        int score = 0;
        for (int i = 0; i < name.length(); i++) {
            int ord = name.charAt(i);
            score += ord - BASE + 1;
        }
        return score * multiplier;
    }
}

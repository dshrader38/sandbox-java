package com.shrader.namescore.scoring.strategy;

import com.shrader.namescore.scoring.NameScoreStrategy;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;


@Component
public class ThirdNameScoreStrategy implements NameScoreStrategy {
    private static final char BASE = 'A';

    @Override
    public int score(List<String> names) {
        names.sort(Comparator.comparing(Object::toString));

        int score = IntStream.range(0, names.size()).parallel()
                .map(i -> scoreName(names.get(i), i + 1))
                .sum();

        return score;
    }

    private int scoreName(String name, int multiplier) {
        int result = 0;

        for (int i = 0; i < name.length(); i++) {
            int ord = name.charAt(i);
            result += ord - BASE + 1;
        }

        return result * multiplier;
    }
}

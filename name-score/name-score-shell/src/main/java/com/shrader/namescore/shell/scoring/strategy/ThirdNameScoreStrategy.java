package com.shrader.namescore.shell.scoring.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;


@Component
public class ThirdNameScoreStrategy implements NameScoreStrategy {
    private static final Logger log = LogManager.getLogger(ThirdNameScoreStrategy.class);

    private static final char BASE = 'A';

    @PostConstruct
    public void init() {
        log.info("init");
    }

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

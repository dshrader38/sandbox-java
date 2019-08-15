package com.shrader.namescore.shell.scoring.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;


@Component
public class FirstNameScoreStrategy implements NameScoreStrategy {
    private static final Logger log = LogManager.getLogger(FirstNameScoreStrategy.class);

    private static final char BASE = 'A';

    @PostConstruct
    public void init() {
        log.info("init");
    }

    @Override
    public int score(List<String> names) {
        names.sort(Comparator.comparing(Object::toString));

        int result = 0;
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);

            result += scoreName(name, i + 1);
        }
        return result;
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

package com.shrader.namescore.scoring.strategy;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;


@Component
@Log4j2
public class FirstNameScoreStrategy implements NameScoreStrategy {

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

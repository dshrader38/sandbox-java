package com.shrader.namescore.scoring;

import com.shrader.namescore.scoring.strategy.FirstNameScoreStrategy;
import com.shrader.namescore.scoring.strategy.SecondNameScoreStrategy;
import com.shrader.namescore.scoring.strategy.ThirdNameScoreStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class NameScoreStrategyFactory {

    /**
     * Takes a string identifying which scoring algorithm to use
     * and returns a Strategy containing the logic for this algorithm.
     * <p>
     *
     * @param strategy
     * @return
     * @throws IllegalArgumentException
     */
    public NameScoreStrategy create(String strategy) throws IllegalArgumentException {
        NameScoreStrategy result;

        NameScoreStrategyEnum nameScoreStrategyEnum = NameScoreStrategyEnum.get(strategy);
        switch (nameScoreStrategyEnum) {
            case FIRST:
                result = new FirstNameScoreStrategy();
                break;
            case SECOND:
                result = new SecondNameScoreStrategy();
                break;
            case THIRD:
                result = new ThirdNameScoreStrategy();
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + strategy);
        }

        return result;
    }

    private enum NameScoreStrategyEnum {
        FIRST("FIRST"),
        SECOND("SECOND"),
        THIRD("THIRD");

        private static final Map<String, NameScoreStrategyEnum> string2Enum = new HashMap<>();

        static {
            for (NameScoreStrategyEnum strategyName : NameScoreStrategyEnum.values()) {
                string2Enum.put(strategyName.getStrategyName(), strategyName);
            }
        }

        private String strategyName;

        NameScoreStrategyEnum(String strategyName) {
            this.strategyName = strategyName;
        }

        public static NameScoreStrategyEnum get(String name) {
            NameScoreStrategyEnum result = string2Enum.get(name.toUpperCase());
            if (result == null) {
                throw new IllegalArgumentException("Please enter a valid strategy!");
            }

            return result;
        }

        public String getStrategyName() {
            return this.strategyName;
        }
    }
}

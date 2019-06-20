package com.shrader.namescore.scoring;

import com.shrader.namescore.scoring.strategy.NameScoreStrategy;
import com.shrader.namescore.scoring.strategy.PrimaryNameScoreStrategy;
import com.shrader.namescore.scoring.strategy.SecondaryNameScoreStrategy;
import com.shrader.namescore.scoring.strategy.TertiaryNameScoreStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class NameScoreStrategyFactory {

    /**
     * Takes a string identifying which scoring algorithm to use
     * and returns a Strategy containing the logic for this algorithm.
     * <p>
     * If an incorrect identifier is given, the factory returns the default BASIC_SCORE strategy
     *
     * @param name
     * @return
     */
    public NameScoreStrategy create(String name) {
        NameScoreStrategy result;

        NameScoreStrategyEnum nameScoreStrategyEnum = NameScoreStrategyEnum.get(name);
        switch (nameScoreStrategyEnum) {
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
                throw new IllegalArgumentException("Unexpected value: " + nameScoreStrategyEnum);
        }

        return result;
    }

    private enum NameScoreStrategyEnum {
        PRIMARY("PRIMARY"),
        SECONDARY("SECONDARY"),
        TERTIARY("TERTIARY");

        private static final Map<String, NameScoreStrategyEnum> nameStringToEnum = new HashMap<>();

        static {
            for (NameScoreStrategyEnum strategyName : NameScoreStrategyEnum.values()) {
                nameStringToEnum.put(strategyName.getStrategyName(), strategyName);
            }
        }

        private String strategyName;

        NameScoreStrategyEnum(String strategyName) {
            this.strategyName = strategyName;
        }

        public static NameScoreStrategyEnum get(String name) {
            NameScoreStrategyEnum result = nameStringToEnum.get(name.toUpperCase());
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

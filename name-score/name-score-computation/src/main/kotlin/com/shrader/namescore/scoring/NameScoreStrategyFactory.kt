package com.shrader.namescore.scoring

import com.shrader.namescore.scoring.strategy.FirstNameScoreStrategy
import com.shrader.namescore.scoring.strategy.SecondNameScoreStrategy
import com.shrader.namescore.scoring.strategy.ThirdNameScoreStrategy
import org.springframework.stereotype.Component
import java.util.*


@Component
class NameScoreStrategyFactory {

    /**
     * Takes a string identifying which scoring algorithm to use
     * and returns a Strategy containing the logic for this algorithm.
     *
     * @param strategy
     * @return
     * @throws IllegalArgumentException
     *
     */
    @Throws(IllegalArgumentException::class)
    fun create(strategy: String): NameScoreStrategy {

        return when (NameScoreStrategyEnum[strategy]) {
            NameScoreStrategyEnum.FIRST -> FirstNameScoreStrategy()
            NameScoreStrategyEnum.SECOND -> SecondNameScoreStrategy()
            NameScoreStrategyEnum.THIRD -> ThirdNameScoreStrategy()
        }
    }

    private enum class NameScoreStrategyEnum(val strategyName: String) {
        FIRST("FIRST"),
        SECOND("SECOND"),
        THIRD("THIRD");

        companion object {
            private val string2Enum = HashMap<String, NameScoreStrategyEnum>()

            init {
                for (strategyName in values()) {
                    string2Enum[strategyName.strategyName] = strategyName
                }
            }

            operator fun get(name: String): NameScoreStrategyEnum {
                return string2Enum[name.toUpperCase()]
                        ?: throw IllegalArgumentException("Please enter a valid strategy!")
            }
        }
    }
}

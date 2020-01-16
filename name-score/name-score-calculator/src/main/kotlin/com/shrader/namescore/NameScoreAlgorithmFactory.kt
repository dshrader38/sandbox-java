package com.shrader.namescore

import com.shrader.namescore.calculator.NameScoreAlgorithm
import com.shrader.namescore.calculator.algorithms.FirstAlgorithm
import com.shrader.namescore.calculator.algorithms.SecondAlgorithm
import com.shrader.namescore.calculator.algorithms.ThirdAlgorithm
import org.springframework.stereotype.Component
import java.util.*


@Component
open class NameScoreAlgorithmFactory {

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
    fun create(strategy: String): NameScoreAlgorithm {

        return when (NameScoreStrategyEnum[strategy]) {
            NameScoreStrategyEnum.FIRST -> FirstAlgorithm()
            NameScoreStrategyEnum.SECOND -> SecondAlgorithm()
            NameScoreStrategyEnum.THIRD -> ThirdAlgorithm()
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

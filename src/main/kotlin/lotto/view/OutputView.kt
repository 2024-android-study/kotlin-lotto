package lotto.view

import lotto.constant.GameMessageConstant
import lotto.service.Converter

class OutputView {

    val converter = Converter

    fun printPublishedLottos(lottos: List<List<Int>>) {
        println(GameMessageConstant.OUTPUT_BUY_LOTTO_NUM.format(lottos.size))
        println(lottos.joinToString("\n"))
        println()
    }

    fun printWinningStatistics(history: List<Pair<Int, Int>>) {
        println(GameMessageConstant.WIN_STATISTICS)
        printWinningHistory(history)
    }

    fun printWinningHistory(history: List<Pair<Int, Int>>) {
        history.forEachIndexed { i, value ->
            when (i) {
                history.lastIndex -> println(GameMessageConstant.OUTPUT_WIN_BONUS_STATISTICS.format(5, converter.markPunctuatedPrice(value.second), value.first))
                else -> println(GameMessageConstant.OUTPUT_WIN_STATISTICS.format(i+3, converter.markPunctuatedPrice(value.second), value.first))
            }
        }
    }
}
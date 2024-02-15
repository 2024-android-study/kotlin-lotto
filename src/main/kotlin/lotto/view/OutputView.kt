package lotto.view

import lotto.constant.GameMessageConstant
import lotto.constant.NumConstant
import lotto.service.Converter

class OutputView {

    val converter = Converter

    fun printPublishedLottos(lottos: List<List<Int>>) {
        println(GameMessageConstant.OUTPUT_BUY_LOTTO_NUM.format(lottos.size))
        println(lottos.joinToString("\n"))
        println()
    }

    fun printWinningStatistics(history: List<Int>) {
        println(GameMessageConstant.WIN_STATISTICS)
        printWinningHistory(history)
    }

    fun printWinningHistory(history: List<Int>) {
        val priceList = listOf(
                NumConstant.WIN_3,
                NumConstant.WIN_4,
                NumConstant.WIN_5,
                NumConstant.WIN_6,
                NumConstant.WIN_5_AND_BONUS
        ).map { converter.markPunctuatedPrice(it) }
        history.forEachIndexed { i, score ->
            when (i) {
                history.lastIndex -> println(GameMessageConstant.OUTPUT_WIN_BONUS_STATISTICS.format(5, priceList[i], score))
                else -> println(GameMessageConstant.OUTPUT_WIN_STATISTICS.format(i+3, priceList[i], score))
            }
        }
    }
}
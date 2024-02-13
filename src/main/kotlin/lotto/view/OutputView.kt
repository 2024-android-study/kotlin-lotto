package lotto.view

import lotto.config.WinningRule
import lotto.model.Lotto

class OutputView {

    fun printLottoNumber(lottoBundle: List<Lotto>) {
        println(PRINT_TOTAL_LOTTO.format(lottoBundle.size))
        for (lotto in lottoBundle) {
            println(lotto.getNumbers().joinToString(", ", "[", "]"))
        }
        println()
    }

    fun printTotalResult() = println(PRINT_TOTAL_RESULT)

    fun printResult(count: Int, rule: WinningRule) {
        println(PRINT_RESULT.format(rule.info, rule.amount, count))
    }

    fun printTotalRate(result: Double) {
        println(PRINT_TOTAL_RATE.format(result))
    }

    companion object {
        private const val PRINT_TOTAL_LOTTO = "%d개를 구매했습니다."
        private const val PRINT_RESULT = "%s (%,d원) - %d개"
        private const val PRINT_TOTAL_RESULT = "당첨 통계\n---"
        private const val PRINT_TOTAL_RATE = "총 수익률은 %.1f%%입니다."
    }
}
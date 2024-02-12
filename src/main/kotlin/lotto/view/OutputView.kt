package lotto.view

import lotto.constants.ViewConstant
import lotto.domain.Lotto

class OutputView {

    // 발행한 로또 수량 및 번호 출력
    fun printLotto(lottoList: List<Lotto>) {
        println(ViewConstant.OUTPUT_NUM_OF_PURCHASE.format(lottoList.size))

        lottoList.forEach {
            it.printNumbers()
        }
    }

    fun printRankComment() {
        println(ViewConstant.LOTTO_STATISTICS)
    }

    fun printRank(matchCount: Int, reward: Int, bonusMatch: Boolean, cnt: Int) {
        if (matchCount == 5 && bonusMatch) {
            println(ViewConstant.RANK_BONUS_MESSAGE.format(matchCount, reward, cnt))
        } else {
            println(ViewConstant.RANK_MESSAGE.format(matchCount, reward, cnt))
        }
    }

    // 수익률 출력
    fun printRate(rate: Double) {
        println(ViewConstant.LOTTO_RATE.format(rate))
    }

}
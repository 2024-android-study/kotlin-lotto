package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.input.InputView
import lotto.output.OutputView

class LottoGame {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val lottoList = mutableListOf<Lotto>()
    private val winList = mutableListOf(0, 0, 0, 0, 0)

    fun run() {
        val money = inputView.inputMoney()

        for(i in 1..money % LOTTO_UNIT) {
            lottoList.add(createLotto())
        }

        outputView.printLotto(lottoList)

        val winNum = inputView.inputWinNum()
        val bonusNum = inputView.inputBonusNum(winNum)

        for(lotto in lottoList) {
            addResultCnt(
                lotto.matchNumbers(winNum),
                lotto.matchBonus(bonusNum)
            )
        }

        outputView.printStatics(winList)
        outputView.printReturn(calculateReturn(winList, money))
    }

    private fun createLotto(): Lotto {
        return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }

    private fun addResultCnt(cnt: Int, isBonusMatched: Boolean) {
        when (cnt) {
            3 -> winList[0]++
            4 -> winList[1]++
            5 -> {
                if (isBonusMatched) {
                    winList[3]++
                } else {
                    winList[2]++
                }
            }
            6 -> winList[4]++
        }
    }

    private fun calculateReturn(winList: List<Int>, money: Int): Float {
        val prizeMoney = listOf(THREE_PRIZE, FOUR_PRIZE, FIVE_PRIZE, FIVE_BONUS_PRIZE, SIX_PRIZE)
        val totalPrizeMoney = winList.indices.sumOf { winList[it].toLong() * prizeMoney[it] }
        return kotlin.math.round(((totalPrizeMoney - money) / money.toFloat()) * 100 * 100) / 100
    }
    companion object {
        const val LOTTO_UNIT = 1000
        const val THREE_PRIZE = 5000
        const val FOUR_PRIZE = 50000
        const val FIVE_PRIZE = 1500000
        const val FIVE_BONUS_PRIZE = 30000000
        const val SIX_PRIZE = 2000000000
    }
}
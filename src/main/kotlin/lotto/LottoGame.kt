package lotto

import lotto.constant.NumConstant
import lotto.service.LottoNumGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame {
    private val inputView = InputView()
    private val outputView = OutputView()

    private var myLottos: MutableList<List<Int>> = mutableListOf()

    fun run() {
        val payment = inputView.readPaymentPrice()
        val paymentLottoNum = purchaseLotto(payment)

        createMyLotto(paymentLottoNum)
        sortMyLotto()
        outputView.printPublishedLottos(myLottos)

        val winNums = inputView.readWinNums()
        val bonusNum = inputView.readBonusNum()

        outputView.printWinningStatistics(compareLotto(winNums, bonusNum))
    }

    private fun purchaseLotto(payment: Int): Int {
        return payment.div(NumConstant.LOTTO_PRICE)
    }

    private fun createMyLotto(num: Int) {
        for (i in 1..num) {
            myLottos.add(LottoNumGenerator().createLotto())
        }
    }

    private fun sortMyLotto() {
        myLottos.forEachIndexed { i, list ->
            myLottos[i] = list.sorted()
        }
    }

    private fun compareLotto(winNums: List<Int>, bonusNum: Int): List<Int> {
        val lotto = Lotto(winNums)
        lotto.initBonusNum(bonusNum)
        lotto.initMyLotto(myLottos)
        lotto.repeatCompare()
        return lotto.winStatus()
    }
}
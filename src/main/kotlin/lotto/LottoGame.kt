package lotto

import lotto.constant.NumConstant
import lotto.service.LottoNumGenerator
import lotto.view.InputView

class LottoGame {
    private val inputView = InputView()
    private var myLottos: MutableList<List<Int>> = mutableListOf()

    fun run() {
        val payment = inputView.readPaymentPrice()
        val paymentLottoNum = purchaseLotto(payment)

        val winNums = inputView.readWinNums()
        val bonusNum = inputView.readBonusNum()

        createMyLotto(paymentLottoNum)
    }

    private fun purchaseLotto(payment: Int): Int {
        return payment.div(NumConstant.LOTTO_PRICE)
    }

    private fun createMyLotto(num: Int) {
        for (i in 1..num) {
            myLottos.add(LottoNumGenerator().createLotto())
        }
        println(myLottos)
    }
}
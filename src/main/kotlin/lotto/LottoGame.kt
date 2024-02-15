package lotto

import lotto.constant.NumConstant
import lotto.view.InputView

class LottoGame {
    private val inputView = InputView()

    fun run() {
        val payment = inputView.readPaymentPrice()
        val lottoNum = purchaseLotto(payment)

        val winNums = inputView.readWinNums()
    }

    private fun purchaseLotto(payment: Int): Int {
        return payment.div(NumConstant.LOTTO_PRICE)
    }
}
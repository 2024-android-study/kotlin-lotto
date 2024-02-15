package lotto

import lotto.constant.NumConstant
import lotto.view.InputView

class LottoGame {
    val inputView = InputView()

    fun run() {
        val payment = inputView.readPaymentPrice()
        val lottoNum = purchaseLotto(payment)
    }

    private fun purchaseLotto(payment: Int): Int {
        return payment.div(NumConstant.LOTTO_PRICE)
    }
}
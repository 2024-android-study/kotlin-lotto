package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constant.GameMessageConstant
import lotto.service.Converter
import lotto.validator.InputValidator

class InputView {

    private val converter = Converter
    private val validator = InputValidator()

    fun readPaymentPrice(): Int {
        println(GameMessageConstant.INPUT_BUY_PRICE)
        val input = Console.readLine()
        val payment = converter.stringToInt(input)
        validator.checkPaymentPrice(payment)
        return payment
    }
}
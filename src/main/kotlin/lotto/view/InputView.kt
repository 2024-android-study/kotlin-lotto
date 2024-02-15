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
        println()
        return payment
    }

    fun readWinNums(): List<Int> {
        println(GameMessageConstant.INPUT_WIN_NUMBERS)
        val input = Console.readLine()
        val winNums = converter.splitComma(input)
        validator.checkWinNums(winNums)
        println()
        return winNums
    }

    fun readBonusNum(): Int {
        println(GameMessageConstant.INPUT_BONUS_NUMBER)
        val input = Console.readLine()
        val bonusNum = converter.stringToInt(input)
        validator.checkNumRange(bonusNum)
        println()
        return bonusNum
    }
}
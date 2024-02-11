package lotto.input

import camp.nextstep.edu.missionutils.Console
import lotto.constant.InputConst

class InputView {
    private val inputValidator = InputValidator()

    fun inputMoney(): Int {
        println(InputConst.INPUT_MONEY)
        val money = Console.readLine()
        return inputValidator.validateMoney(money)
    }

    fun inputWinNum(): Int {
        println(InputConst.INPUT_WIN_NUM)
        val num = Console.readLine()
        return inputValidator.validateWinNum(num)
    }

    fun inputBonusNum(): Int {
        println(InputConst.INPUT_BONUS_NUM)
        val num = Console.readLine()
        return inputValidator.validateBonusNum(num)
    }
}
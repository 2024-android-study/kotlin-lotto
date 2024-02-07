package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.ViewConstant
import lotto.domain.Lotto
import lotto.validation.InputValidator

class InputView {

    private val inputValidator = InputValidator()
    private val lottoNumbers = mutableListOf<Int>()

    // 구입 금액 입력
    fun inputMoney(): Int {
        println(ViewConstant.INPUT_MONEY)

        val input = Console.readLine()

        return inputValidator.validateMoney(input)
    }

    // 당첨 번호 입력
    fun inputWinningNumber(): Lotto {
        println(ViewConstant.INPUT_LOTTO_NUM)

        val input = Console.readLine()?.replace(" ", "")!!
        lottoNumbers.addAll(inputValidator.validateLottoNum(input))

        return Lotto(lottoNumbers)
    }

    // 보너스 번호 입력
    fun inputBonusNumber(): Int {
        println(ViewConstant.INPUT_BONUS_NUM)

        val input = Console.readLine()

        return inputValidator.validateBonusNum(input)
    }

}
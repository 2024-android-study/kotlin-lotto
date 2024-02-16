package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.config.error.BonusNumberError
import lotto.extension.toIntList
import lotto.validation.InputValidator

// 입력 예외 처리 - while, try-catch 에러 문구 출력 후 재입력
class InputView {

    // 금액 입력
    fun readAmount(): Int {
        println(READ_AMOUNT)
        while (true) {
            try {
                val input = Console.readLine()
                InputValidator.checkAmount(input)
                println()
                return input.toInt()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    // 당첨 번호 입력
    fun readWinningNumbers(): List<Int> {
        println(READ_WINNING_NUMBERS)
        while (true) {
            try {
                val input = Console.readLine()
                InputValidator.checkWinningNumber(input)
                println()
                return input.toIntList()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    // 보너스 번호 입력
    fun readBonusNumber(winningNumber: List<Int>): Int {
        println(READ_BONUS_NUMBER)
        while (true) {
            try {
                val input = Console.readLine()
                InputValidator.checkBonusNumber(input)
                BonusNumberError.requireNonDuplicate(input, winningNumber)
                println()
                return input.toInt()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    companion object {
        private const val READ_AMOUNT = "구입금액을 입력해 주세요."
        private const val READ_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
        private const val READ_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    }
}
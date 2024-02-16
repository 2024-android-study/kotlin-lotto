package lotto.validation

import lotto.config.error.AmountError
import lotto.config.error.BonusNumberError
import lotto.config.error.CommonError
import lotto.config.error.WinningNumberError

object InputValidator {

    fun checkAmount(input: String) {
        CommonError.requireNonEmpty(input)
        CommonError.requireNoSpace(input)
        CommonError.requireNoChar(input)
        AmountError.requireValidAmountRange(input)
        AmountError.requireValidUnit(input)
    }

    fun checkWinningNumber(input: String) {
        CommonError.requireNonEmpty(input)
        CommonError.requireNoSpace(input)
        WinningNumberError.requireNotContainChar(input)
        WinningNumberError.requireValidSize(input)
        WinningNumberError.requireValidNumber(input)
        WinningNumberError.requireNotDuplicate(input)
    }

    fun checkBonusNumber(input: String) {
        CommonError.requireNonEmpty(input)
        CommonError.requireNoSpace(input)
        CommonError.requireNoChar(input)
        BonusNumberError.requireValidNumberRange(input)
    }
}
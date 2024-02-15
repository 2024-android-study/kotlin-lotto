package lotto.validator

import lotto.constant.ErrorMessageConstant
import lotto.constant.NumConstant

class InputValidator {

    fun checkIsNum(input: String) {
        require(input.all { it.isDigit() }) {
            ErrorMessageConstant.ERROR_NOT_NUM
        }
    }

    fun checkPaymentPrice(price: Int) {
        require(price % NumConstant.LOTTO_PRICE == 0) {
            ErrorMessageConstant.ERROR_NOT_DIVIDED
        }
    }
}
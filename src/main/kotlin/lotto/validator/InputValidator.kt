package lotto.validator

import lotto.constant.ErrorMessageConstant
import lotto.constant.NumConstant

class InputValidator {

    fun checkIsNum(input: String) {
        require(input.all { it.isDigit() }) {
            ErrorMessageConstant.ERROR_NOT_NUM
        }
    }

    fun checkAllIsNum(input: List<String>) {
        input.forEach {
            checkIsNum(it)
        }
    }

    fun checkPaymentPrice(price: Int) {
        require(price % NumConstant.LOTTO_PRICE == 0) {
            ErrorMessageConstant.ERROR_NOT_DIVIDED
        }
    }

    fun checkWinNums(nums: List<Int>) {
        checkNumSize(nums)
        nums.forEach {
            checkNumRange(it)
        }
        checkNumDuplication(nums)
    }

    private fun checkNumSize(nums: List<Int>) {
        require(nums.size == NumConstant.LOTTO_NUM) {
            ErrorMessageConstant.ERROR_LOTTO_NUM_SIZE
        }
    }

    fun checkNumRange(num: Int) {
        require(num >= NumConstant.NUMBER_RANGE_START && num <= NumConstant.NUMBER_RANGE_END) {
            ErrorMessageConstant.ERROR_LOTTO_NUM_RANGE
        }
    }

    private fun checkNumDuplication(nums: List<Int>) {
        require(nums.distinct().count() == NumConstant.LOTTO_NUM) {
            ErrorMessageConstant.ERROR_LOTTO_DUPLICATION
        }
    }

}
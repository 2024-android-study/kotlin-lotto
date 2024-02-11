package lotto.input

import lotto.constant.ErrorConstant

class InputValidator {
    fun validateMoney(money: String): Int {
        require(money.isNotEmpty()) { ErrorConstant.ERROR_EMPTY }
        require(money.isNumber()) { ErrorConstant.ERROR_NUM }
        require(money.toInt() > 1000) { ErrorConstant.ERROR_NUM }
        require(money.toInt() % 1000 == 0) { ErrorConstant.ERROR_NUM }
        return money.toInt()
    }

    fun validateWinNum(input: String): List<Int> {
        require(input.isNotEmpty()) { ErrorConstant.ERROR_EMPTY }
        val winNumbers = input.split(",")
        require(winNumbers.size == LOTTO_NUM) { ErrorConstant.ERROR_LOTTO_NUM_CNT }
        require(winNumbers.toSet().size == winNumbers.size) { ErrorConstant.ERROR_LOTTO_NUM_DUPLICATE }
        winNumbers.forEach {
            require(it.isNumber()) { ErrorConstant.ERROR_NUM }
            require(it.isNumberInRange()) { ErrorConstant.ERROR_NUM_RANGE }
        }
        return winNumbers.map { it.toInt() }
    }

    fun validateBonusNum(num: String, winNumbers: List<Int>): Int {
        require(num.isNotEmpty()) { ErrorConstant.ERROR_EMPTY }
        require(num.isNumber()) { ErrorConstant.ERROR_NUM }
        require(num.isNumberInRange()) { ErrorConstant.ERROR_NUM_RANGE }
        require(!winNumbers.contains(num.toInt())) { ErrorConstant.ERROR_BONUS_NUM_DUPLICATE }

        return num.toInt()
    }

    private fun String.isNumber(): Boolean {
        return this.all { i -> i.isDigit() }
    }

    private fun String.isNumberInRange(): Boolean {
        return this.toInt() in MIN_NUM..MAX_NUM
    }

    companion object NumConstant {
        const val MIN_NUM = 1
        const val MAX_NUM = 45
        const val LOTTO_NUM = 6
        const val LOTTO_BONUS_NUM = 7
    }
}
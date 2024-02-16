package lotto.input

import lotto.constant.ErrorConst

class InputValidator {
    fun validateMoney(money: String): Int {
        require(money.isNotEmpty()) { ErrorConst.ERROR_EMPTY }
        require(money.isNumber()) { ErrorConst.ERROR_NUM }
        require(money.toInt() > LOTTO_UNIT) { ErrorConst.ERROR_MONEY_MIN }
        require(money.toInt() % LOTTO_UNIT == 0) { ErrorConst.ERROR_MONEY_UNIT }
        return money.toInt()
    }

    fun validateWinNum(input: String): List<Int> {
        require(input.isNotEmpty()) { ErrorConst.ERROR_EMPTY }
        val winNumbers = input.split(",")
        require(winNumbers.size == LOTTO_NUM) { ErrorConst.ERROR_LOTTO_NUM_CNT }
        require(winNumbers.toSet().size == winNumbers.size) { ErrorConst.ERROR_LOTTO_NUM_DUPLICATE }
        winNumbers.forEach {
            require(it.isNumber()) { ErrorConst.ERROR_NUM }
            require(it.isNumberInRange()) { ErrorConst.ERROR_NUM_RANGE }
        }
        return winNumbers.map { it.toInt() }
    }

    fun validateBonusNum(num: String, winNumbers: List<Int>): Int {
        require(num.isNotEmpty()) { ErrorConst.ERROR_EMPTY }
        require(num.isNumber()) { ErrorConst.ERROR_NUM }
        require(num.isNumberInRange()) { ErrorConst.ERROR_NUM_RANGE }
        require(!winNumbers.contains(num.toInt())) { ErrorConst.ERROR_BONUS_NUM_DUPLICATE }

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
        const val LOTTO_UNIT = 1000
        const val LOTTO_NUM = 6
    }
}
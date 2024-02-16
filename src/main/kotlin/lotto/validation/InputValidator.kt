package lotto.validation

import lotto.constants.ErrorConstant
import lotto.constants.NumConstant

class InputValidator {

    private var lottoNumbers = mutableListOf<Int>()

    // 구입 금액 검증
    fun validateMoney(input: String): Int {
        require(input.isNotEmpty()) {ErrorConstant.ERROR_EMPTY}
        require(!input.contains(" ")) {ErrorConstant.ERROR_MONEY_BLANK}
        require(isNumber(input)) {ErrorConstant.ERROR_NUM}
        require(input.toInt() >= 0) {ErrorConstant.ERROR_MONEY_MINUS}
        require(input.toInt() >= 1000) {ErrorConstant.ERROR_MONEY_MIN}
        require(input.toInt() % 1000 == 0) {ErrorConstant.ERROR_MONEY_ZERO_UNIT}

        return input.toInt()
    }

    // 당첨 번호 검증
    fun validateLottoNum(input: String): List<Int> {
        require(input.isNotEmpty()) {ErrorConstant.ERROR_EMPTY}

        val numbers = input.split(",")

        require(numbers.size == NumConstant.LOTTO_CNT) {ErrorConstant.ERROR_NUM_CNT}
        require(numbers.toSet().size == NumConstant.LOTTO_CNT) {ErrorConstant.ERROR_NUM_DUPLICATE}

        numbers.forEach {
            require(isNumber(it)) {ErrorConstant.ERROR_NUM}
            require(it.toInt() in (NumConstant.MIN_RANDOM_NUM..NumConstant.MAX_RANDOM_NUM)) {ErrorConstant.ERROR_NUM_RANGE}
        }

        lottoNumbers = numbers.map { it.toInt() }.toMutableList()

        return numbers.map { it.toInt() }
    }

    // 보너스 번호 검증
    fun validateBonusNum(input: String): Int {
        require(input.isNotEmpty()) {ErrorConstant.ERROR_EMPTY}
        require(!input.contains(" ")) {ErrorConstant.ERROR_MONEY_BLANK}
        require(!input.contains(",")) {ErrorConstant.ERROR_BONUS_NUM}
        require(isNumber(input)) {ErrorConstant.ERROR_NUM}
        require(input.toInt() in (NumConstant.MIN_RANDOM_NUM..NumConstant.MAX_RANDOM_NUM)) {ErrorConstant.ERROR_NUM_RANGE}
        require(!isDuplicateBonusNum(input.toInt(), lottoNumbers)) {ErrorConstant.ERROR_BONUS_NUM_DUPLICATE}

        return input.toInt()
    }

    // 보너스 번호가 당첨 번호와 중복되는지 확인
    private fun isDuplicateBonusNum(num: Int, lottoNumbers: MutableList<Int>): Boolean {
        lottoNumbers.add(num)
        return lottoNumbers.toSet().size != NumConstant.LOTTO_BONUS_CNT
    }

    // 숫자인지 확인
    private fun isNumber(input: String): Boolean {
        return input.all { ch -> ch.isDigit() }
    }
}
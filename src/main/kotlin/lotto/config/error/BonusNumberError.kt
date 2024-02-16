package lotto.config.error

enum class BonusNumberError(val message: String) {
    DUPLICATE_BONUS_NUMBER_AND_WINNING_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다."),
    INVALID_NUMBER_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    companion object {
        fun requireNonDuplicate(bonusNumber: String, winningNumber: List<Int>) {
            require(winningNumber.contains(bonusNumber.toInt()).not()) { DUPLICATE_BONUS_NUMBER_AND_WINNING_NUMBER.message }
        }

        fun requireValidNumberRange(input: String) {
            require(input.toInt() in 1..45) { INVALID_NUMBER_RANGE.message }
        }
    }
}
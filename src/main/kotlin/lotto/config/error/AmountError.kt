package lotto.config.error

enum class AmountError(val message: String) {
    INVALID_UNIT("[ERROR] 금액은 천원 단위로 입력해 주세요."),
    INVALID_AMOUNT_RANGE("[ERROR] 금액은 천원 이상 입력해 주세요.");

    companion object {
        fun requireValidAmountRange(input: String) {
            require(input.toInt() >= 1000) { INVALID_AMOUNT_RANGE.message }
        }

        fun requireValidUnit(input: String) {
            require(input.toInt() % 1000 == 0) { INVALID_UNIT.message }
        }
    }
}
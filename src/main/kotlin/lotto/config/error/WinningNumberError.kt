package lotto.config.error

enum class WinningNumberError(val message: String) {
    CONTAIN_CHAR("[ERROR] 문자가 포함되어 있습니다. 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    OUT_RANGE_SIZE("[ERROR] 총 6개의 숫자만 입력 가능합니다."),
    OUT_RANGE_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 숫자가 중복되었습니다. 다시 입력해 주세요.");

    companion object {
        fun requireNotContainChar(input: String) {
            input.split(",").forEach {
                require(it.matches(Regex("\\d+"))) { CONTAIN_CHAR.message }
            }
        }

        fun requireValidSize(input: String) {
            require(input.split(",").size == 6) { OUT_RANGE_SIZE.message }
        }

        fun requireValidNumber(input: String) {
            input.split(",").forEach {
                require(it.toInt() in 1..45) { OUT_RANGE_NUMBER.message }
            }
        }

        fun requireNotDuplicate(input: String) {
            val numbers = input.split(",")
            require(numbers.size == numbers.toSet().size) { DUPLICATE_NUMBER.message }
        }
    }
}
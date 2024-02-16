package lotto.config.error

enum class CommonError(val message: String) {
    EMPTY_INPUT("[ERROR] 값을 입력하지 않았습니다. 다시 입력해 주세요."),
    CONTAIN_SPACE("[ERROR] 공백이 포함되어 있습니다. 다시 입력해 주세요"),
    CONTAIN_CHAR("[ERROR] 문자가 포함되어 있습니다. 다시 입력해 주세요.");

    companion object {
        fun requireNonEmpty(input: String) {
            require(input.isNotEmpty()) { EMPTY_INPUT.message }
        }

        fun requireNoSpace(input: String) {
            require(!input.contains(" ")) { CONTAIN_SPACE.message }
        }

        fun requireNoChar(input: String) {
            require(input.matches(Regex("\\d+"))) { CONTAIN_CHAR.message }
        }
    }
}
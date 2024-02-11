package lotto.constant

enum class ErrorConstant(s: String) {
    ERROR_EMPTY("값을 입력하세요."),
    ERROR_NUM("숫자만 입력해주세요."),

    ERROR_MONEY_MIN("금액을 1,000원 이상 입력해주세요."),
    ERROR_MONEY_UNIT("1,000원 단위로 입력해주세요."),

    ERROR_NUM_RANGE("1~45 범위의 숫자를 입력해주세요."),
    ERROR_LOTTO_NUM_CNT("6개의 숫자를 입력해주세요."),
    ERROR_LOTTO_NUM_DUPLICATE("중복되지 않는 숫자를 입력해주세요"),

    ERROR_BONUS_NUM_DUPLICATE("당첨 숫자와 중복되지 않는 숫자를 입력해주세요.");
}
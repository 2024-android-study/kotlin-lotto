package lotto.constants

object ErrorConstant {
    const val ERROR_EMPTY = "[ERROR] 값을 입력해 주세요."
    const val ERROR_NUM = "[ERROR] 숫자를 입력해 주세요."

    const val ERROR_MONEY_BLANK = "[ERROR] 공백을 포함할 수 없습니다."
    const val ERROR_MONEY_MINUS = "[ERROR] 음수를 입력할 수 없습니다."
    const val ERROR_MONEY_MIN = "[ERROR] 최소 1,000을 입력해야 합니다."
    const val ERROR_MONEY_ZERO_UNIT = "[ERROR] 1,000원 단위로 입력해야 합니다."

    const val ERROR_NUM_RANGE = "[ERROR] 1 ~ 45 사이의 숫자를 입력해야 합니다."
    const val ERROR_NUM_CNT = "[ERROR] 6개의 숫자를 입력해야 합니다."
    const val ERROR_NUM_DUPLICATE = "[ERROR] 중복된 숫자를 입력할 수 없습니다."

    const val ERROR_BONUS_NUM = "[ERROR] 보너스 번호는 1개만 입력할 수 있습니다."
    const val ERROR_BONUS_NUM_DUPLICATE = "[ERROR] 당첨 숫자와 중복된 숫자를 입력할 수 없습니다."
}
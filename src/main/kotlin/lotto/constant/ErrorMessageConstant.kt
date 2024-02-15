package lotto.constant

object ErrorMessageConstant {
    const val ERROR_NOT_NUM = "[ERROR] 유효한 숫자가 입력되어야 합니다."
    const val ERROR_NOT_DIVIDED = "[ERROR] 구입 금액은 ${NumConstant.LOTTO_PRICE}로 나누어 떨어져야 합니다."

    const val ERROR_LOTTO_NUM_SIZE = "[ERROR] 로또 번호는 ${NumConstant.LOTTO_NUM}개여야 합니다."
    const val ERROR_LOTTO_NUM_RANGE = "[ERROR] 로또 번호는 ${NumConstant.NUMBER_RANGE_START}부터 ${NumConstant.NUMBER_RANGE_END} 사이의 숫자여야 합니다."
    const val ERROR_LOTTO_DUPLICATION = "[ERROR] 로또 번호는 중복되지 않은 숫자여야 합니다."
}
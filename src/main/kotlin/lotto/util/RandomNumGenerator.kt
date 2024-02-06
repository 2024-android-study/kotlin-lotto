package lotto.util

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.NumConstant

object RandomNumGenerator {
    // 랜덤값 생성, 겹치지 않는 숫자 반환
    fun generateNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(NumConstant.MIN_RANDOM_NUM, NumConstant.MAX_RANDOM_NUM, NumConstant.LOTTO_CNT).sorted() // 오름차순 정렬
    }
}
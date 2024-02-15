package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.constant.NumConstant

class LottoNumGenerator {
    fun createLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(NumConstant.NUMBER_RANGE_START, NumConstant.NUMBER_RANGE_END, NumConstant.LOTTO_NUM)
    }
}
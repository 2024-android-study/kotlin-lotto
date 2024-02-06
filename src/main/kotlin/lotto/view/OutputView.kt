package lotto.view

import lotto.constants.ViewConstant
import lotto.domain.Lotto

class OutputView {

    // 발행한 로또 수량 및 번호 출력
    fun printLotto(lottoList: List<Lotto>) {
        println(ViewConstant.OUTPUT_NUM_OF_PURCHASE.format(lottoList.size))

        lottoList.forEach {
            it.printNumbers()
        }
    }

}
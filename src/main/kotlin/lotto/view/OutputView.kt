package lotto.view

import lotto.constant.GameMessageConstant

class OutputView {
    fun printPublishedLottos(lottos: MutableList<List<Int>>) {
        println(GameMessageConstant.OUTPUT_BUY_LOTTO_NUM.format(lottos.size))
        lottos.forEachIndexed { i, list ->
            lottos[i] = list.sorted()
        }
        println(lottos.joinToString("\n"))
    }
}
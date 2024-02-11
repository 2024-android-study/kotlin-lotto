package lotto.output

import lotto.Lotto
import lotto.constant.OutputConst

class OutputView {
    fun printLotto(lottos: List<Lotto>) {
        println(OutputConst.OUTPUT_BUY.formatted(lottos.size))
        for(lotto in lottos) {
            println(lotto)
        }
    }

    fun printStatics(winList: List<Int>) {
        println(OutputConst.OUTPUT_STATICS)
        println(OutputConst.OUTPUT_3_MATCH.formatted(winList[0]))
        println(OutputConst.OUTPUT_4_MATCH.formatted(winList[1]))
        println(OutputConst.OUTPUT_5_MATCH.formatted(winList[2]))
        println(OutputConst.OUTPUT_5_MATCH_BONUS.formatted(winList[3]))
        println(OutputConst.OUTPUT_6_MATCH.formatted(winList[4]))
    }

    fun printReturn(rate: Float) {
        println(OutputConst.OUTPUT_RETURN.formatted(rate))
    }
}
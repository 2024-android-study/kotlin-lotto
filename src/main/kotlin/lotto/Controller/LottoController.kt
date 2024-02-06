package lotto.Controller

import lotto.domain.Lotto
import lotto.util.RandomNumGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val money = inputView.inputMoney()

        val lottoList = createLotto(money)
        outputView.printLotto(lottoList)


    }

    // 구입 금액만큼 로또 발행
    private fun createLotto(money: Int): List<Lotto> {
        val cnt = money / 1000
        val lottoList = mutableListOf<Lotto>()

        repeat(cnt) {
            lottoList.add(Lotto(RandomNumGenerator.generateNumbers()))
        }

        return lottoList
    }
}
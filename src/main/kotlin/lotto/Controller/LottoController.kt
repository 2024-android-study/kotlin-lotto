package lotto.Controller

import lotto.domain.Lotto
import lotto.domain.Rank
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

        val winningNumbers = inputView.inputWinningNumber()
        val bonusNumber = inputView.inputBonusNumber()

        var lottoResult = matchLottoNum(lottoList, winningNumbers, bonusNumber)

        lottoResult = sortLottoResult(lottoResult)
        showLottoResult(money, lottoResult)
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

    // 로또 당첨 확인
    private fun matchLottoNum(lottoList: List<Lotto>, winningNumbers: Lotto, bonusNumber: Int): MutableMap<Rank, Int> {
        val lottoResult = makeLottoResultMap()

        lottoList.forEach {
            val lottoNumberCount = it.getMatchLottoNum(winningNumbers)
            val bonusMatch = it.matchBonusNum(bonusNumber)

            val rank = Rank.matchRank(lottoNumberCount, bonusMatch)
            lottoResult[rank] = lottoResult.getOrDefault(rank, 0) + 1
        }

        lottoResult.remove(Rank.NONE)

        return lottoResult
    }

    // 당첨 통계 내역 맵 만들기
    private fun makeLottoResultMap(): MutableMap<Rank, Int> {
        val lottoResult = mutableMapOf<Rank, Int>()

        for (rank in Rank.entries) {
            lottoResult[rank] = 0
        }

        return lottoResult
    }

    // 맵을 상금 기준으로 오름차순 정렬
    private fun sortLottoResult(lottoResult: MutableMap<Rank, Int>): MutableMap<Rank, Int> {
        return lottoResult.toList().sortedBy { it.first.getReward() }.toMap().toMutableMap()
    }

    // 당첨 통계 및 수익률 출력
    private fun showLottoResult(money: Int, lottoResult: MutableMap<Rank, Int>) {
        var sum = 0 // 총 상금
        outputView.printRankComment()

        lottoResult.forEach {
            val key = it.key
            val value = it.value

            outputView.printRank(key.getMatchCount(), key.getReward(), key.getBonusMatch(), it.value)

            sum += key.getReward() * value
        }

        outputView.printRate(calculateRate(money, sum))
    }

    // 수익률 계산
    private fun calculateRate(money: Int, reward: Int): Double {
        return reward / money.toDouble()
    }
}
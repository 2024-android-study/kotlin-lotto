package lotto.di

import lotto.config.WinningRule
import lotto.extension.filteredByRule
import lotto.model.BonusNumber
import lotto.model.Lotto
import lotto.model.Seller
import lotto.view.InputView
import lotto.view.OutputView

class LottoApp(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val seller: Seller
) {
    private var lottoBundle: List<Lotto> = emptyList()
    private lateinit var winningNumbers: Lotto
    private lateinit var bonusNumber: BonusNumber
    private val lottoResult: MutableList<WinningRule> = mutableListOf()

    // App 실행
    fun run() {
        purchaseLotto()
        viewLottoNumber()
        selectWinningNumbers()
        selectBonusNumber()
        compareLotto()
        viewTotalResult()
    }

    // 로또 구매
    private fun purchaseLotto() {
        val amount = inputView.readAmount()
        lottoBundle = seller.sellLotto(amount)
    }

    // 구매한 로또 번호 출력
    private fun viewLottoNumber() = outputView.printLottoNumber(lottoBundle)

    // 당첨 번호 입력
    private fun selectWinningNumbers() {
        val numbers = inputView.readWinningNumbers()
        winningNumbers = Lotto(numbers)
    }

    // 보너스 번호 입력
    private fun selectBonusNumber() {
        val number = inputView.readBonusNumber(winningNumbers.getNumbers())
        bonusNumber = BonusNumber(number)
    }

    // 로또 번호 비교
    private fun compareLotto() {
        lottoResult.addAll(lottoBundle.map { lotto ->
            val count = lotto.compareWinningNumbers(winningNumbers)
            WinningRule.find(lotto, count, bonusNumber)
        })
    }

    // 전체 결과 출력
    private fun viewTotalResult() {
        outputView.printTotalResult()
        var amount = 0

        enumValues<WinningRule>()
            .filter { it != WinningRule.ELSE }
            .forEach { rule ->
                val result = lottoResult.filteredByRule(rule)
                amount += seller.calculatePrize(result.size, rule.amount)
                outputView.printResult(result.size, rule)
            }

        viewRate(amount)
    }

    // 수익률 출력
    private fun viewRate(amount: Int) {
        val result = seller.calculateRateOfReturn(amount)
        outputView.printTotalRate(result)
    }
}
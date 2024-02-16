package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class Seller {

    private var money = 0

    fun sellLotto(amount: Int): List<Lotto> {
        money = amount
        val lottoBundle = arrayListOf<Lotto>()
        for (i in 1..amount / LOTTO_PRICE) {
            val numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_FIRST, LOTTO_NUMBER_LAST, TOTAL_NUMBER_COUNT)
            lottoBundle.add(Lotto(numbers))
        }
        return lottoBundle
    }

    fun calculatePrize(count: Int, amount: Int): Int {
        return count * amount
    }

    fun calculateRateOfReturn(amount: Int): Double {
        return amount.toDouble() / money.toDouble() * 100
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val LOTTO_NUMBER_FIRST = 1
        private const val LOTTO_NUMBER_LAST = 45
        private const val TOTAL_NUMBER_COUNT = 6
    }
}
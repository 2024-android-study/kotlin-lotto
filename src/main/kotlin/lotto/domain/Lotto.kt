package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    // 로또 번호 출력
    fun printNumbers() {
        println(this.numbers)
    }

    private fun getNumbers(): List<Int> {
        return this.numbers
    }

    // 당첨 번호와 비교
    fun getMatchLottoNum(winningNumbers: Lotto): Int {
        return this.numbers.count { it in winningNumbers.getNumbers() }
    }

    // 보너스 번호가 있는지 확인
    fun matchBonusNum(bonus: Int): Boolean {
        return this.numbers.any { it == bonus }
    }

}

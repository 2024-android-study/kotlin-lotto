package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun matchNumbers(winNum: List<Int>): Int {
        return this.numbers.count { it in winNum }
    }

    fun matchBonus(bonusNum: Int): Boolean = bonusNum in numbers
}

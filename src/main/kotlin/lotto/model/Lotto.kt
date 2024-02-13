package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.toSet().size)
    }

    fun getNumbers(): List<Int> = numbers.sorted()

    fun compareWinningNumbers(winningLotto: Lotto): Int {
        var count = 0
        for (number in numbers) {
            if (winningLotto.getNumbers().contains(number)) count++
        }
        return count
    }
}

package lotto.model

class BonusNumber(private val number: Int) {

    fun isContain(lotto: Lotto): Boolean {
        return lotto.getNumbers().contains(number)
    }
}
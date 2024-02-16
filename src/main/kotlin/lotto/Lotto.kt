package lotto

import lotto.validator.InputValidator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)

        val validator = InputValidator()
        validator.checkWinNums(numbers)
    }

    private var bonusNum: Int = 0
    private lateinit var myLottos: List<List<Int>>

    var resultList = MutableList<Int>(5) { 0 } // 마지막 리스트가 보너스

    fun initBonusNum(num: Int) {
        this.bonusNum = num
    }

    fun initMyLotto(lottos: List<List<Int>>) {
        this.myLottos = lottos
    }

    fun repeatCompare() {
        for (lotto in myLottos) {
            updateIdenticalNum(lotto)
        }
    }

    fun winStatus(): List<Int> {
        return resultList
    }

    private fun updateIdenticalNum(lotto: List<Int>) {
        val winNum = findIdenticalNum(lotto)
        when (winNum) {
            5 -> updateBonusNum(lotto, winNum)
            else -> {
                updateWinNum(winNum)
            }
        }
    }

    private fun findIdenticalNum(myLotto: List<Int>): Int { // 일치하는 개수 찾기
        var duplicates = 0
        myLotto.forEach{ num ->
            if (numbers.contains(num)) duplicates++
        }
        return duplicates
    }

    private fun updateWinNum(winNum: Int) {
        if (winNum in MIN_COUNT..MAX_COUNT) {
            resultList[winNum - MIN_COUNT]++
        }
    }

    private fun updateBonusNum(lotto: List<Int>, winNum: Int) {
        if (lotto.contains(bonusNum)) // 보너스 점수 계산
            resultList[resultList.lastIndex]++
        else
            resultList[winNum - MIN_COUNT]++
    }

    companion object {
        const val MIN_COUNT = 3
        const val MAX_COUNT = 6
    }
}

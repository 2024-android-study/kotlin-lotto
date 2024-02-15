package lotto.service

import lotto.validator.InputValidator

object Converter {

    private const val DELIMINATOR = ","

    private val validator = InputValidator()

    fun stringToInt(input: String): Int {
        validator.checkIsNum(input)
        return input.toInt()
    }

    fun splitComma(str: String): List<Int> {
        val list = str.split(DELIMINATOR)
        return stringListToIntList(list)
    }

    private fun stringListToIntList(list: List<String>): List<Int> {
        validator.checkAllIsNum(list)
        return list.map { it.toInt() }.toList()
    }

}
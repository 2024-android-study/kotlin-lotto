package lotto.service

import lotto.validator.InputValidator

object Converter {

    val validator = InputValidator()

    fun stringToInt(input: String): Int {
        validator.checkIsNum(input)
        return input.toInt()
    }

}
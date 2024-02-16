package lotto.extension

import lotto.config.WinningRule

fun String.toIntList(): List<Int> {
    return split(",")
        .map { it.toInt() }
}

fun List<WinningRule>.filteredByRule(rule: WinningRule): List<WinningRule> {
    return this.filter { it == rule }
}
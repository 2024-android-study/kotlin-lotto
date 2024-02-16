package lotto.config

import lotto.model.BonusNumber
import lotto.model.Lotto

enum class WinningRule(val info: String, val amount: Int, val count: Int) {
    ELSE("꽝", 0, 0),
    FIFTH("3개 일치", 5_000, 3),
    FOURTH("4개 일치", 50_000, 4),
    THIRD("5개 일치", 1_500_000, 5),
    SECOND("5개 일치, 보너스 볼 일치", 30_000_000, 5),
    First("6개 일치", 2_000_000_000, 6);

    companion object {
        fun find(lotto: Lotto, count: Int, bonusNumber: BonusNumber) = when {
            count == First.count -> First
            count == SECOND.count && bonusNumber.isContain(lotto) -> WinningRule.SECOND
            count == THIRD.count -> THIRD
            count == FOURTH.count -> FOURTH
            count == FIFTH.count -> FIFTH
            else -> ELSE
        }
    }
}
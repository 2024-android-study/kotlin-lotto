package lotto.domain

enum class Rank(private val matchCount: Int, private val reward: Int, private val bonusMatch: Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    fun getReward(): Int {
        return reward
    }

    fun getMatchCount(): Int {
        return matchCount
    }

    fun getBonusMatch(): Boolean {
        return bonusMatch
    }

    companion object {
        fun matchRank(matchCount: Int, bonusMatch: Boolean): Rank {
            if (matchCount == 5) {
                return entries.firstOrNull { it.matchCount == matchCount && it.bonusMatch == bonusMatch } ?: NONE
            }

            return entries.firstOrNull { it.matchCount == matchCount } ?: NONE
        }
    }
}

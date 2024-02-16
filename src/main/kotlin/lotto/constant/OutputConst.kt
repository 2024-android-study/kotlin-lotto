package lotto.constant

enum class OutputConst(val s: String) {
    OUTPUT_BUY("%d개를 구매했습니다."),
    OUTPUT_STATICS("\n당첨 통계\n---"),

    OUTPUT_3_MATCH("3개 일치 (5,000원) - %d개"),
    OUTPUT_4_MATCH("4개 일치 (50,000원) - %d개"),
    OUTPUT_5_MATCH("5개 일치 (1,500,000원) - %d개"),
    OUTPUT_5_MATCH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    OUTPUT_6_MATCH("6개 일치 (2,000,000,000원) - %d개"),

    OUTPUT_RETURN("총 수익률은 %.1f%%입니다.");

    fun formatted(vararg args: Any): String {
        return s.format(*args)
    }
}
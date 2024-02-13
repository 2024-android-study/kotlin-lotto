package lotto.di

import lotto.model.Seller
import lotto.view.InputView
import lotto.view.OutputView

// DI, Singleton
object AppModule {

    // 프로퍼티 지연 초기화
    private val lottoAppInstance by lazy {
        val inputView = InputView()
        val outputView = OutputView()
        val seller = Seller()
        LottoApp(inputView, outputView, seller)
    }

    fun provideLottoApp(): LottoApp {
        return lottoAppInstance
    }
}
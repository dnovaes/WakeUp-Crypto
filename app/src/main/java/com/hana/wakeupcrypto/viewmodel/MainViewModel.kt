package com.hana.wakeupcrypto.viewmodel

import androidx.lifecycle.ViewModel
import com.hana.wakeupcrypto.domain.model.Currency
import com.hana.wakeupcrypto.domain.model.Spot

class MainViewModel: ViewModel() {

    fun getCurrencies() = listOf<Currency>(
        Spot("BNB", "572.4"),
        Spot("BCOIN", "5.83")
    )
}
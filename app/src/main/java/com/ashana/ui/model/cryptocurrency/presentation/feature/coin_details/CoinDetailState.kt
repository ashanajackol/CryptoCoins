package com.ashana.ui.model.cryptocurrency.presentation.feature.coin_details

import com.ashana.ui.model.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val success: CoinDetail? = null,
    val loading: Boolean = false,
    val error: String = ""
)
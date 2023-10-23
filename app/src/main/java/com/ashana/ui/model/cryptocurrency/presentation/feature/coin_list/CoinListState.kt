package com.ashana.ui.model.cryptocurrency.presentation.feature.coin_list

import com.ashana.ui.model.cryptocurrency.domain.model.Coin

data class CoinListState(
    val loading: Boolean = false,
    val success: List<Coin> = listOf(),
    val error: String? = null
)
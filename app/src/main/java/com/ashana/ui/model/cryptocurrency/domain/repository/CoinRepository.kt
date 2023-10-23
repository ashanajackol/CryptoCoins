package com.ashana.ui.model.cryptocurrency.domain.repository

import com.ashana.ui.model.cryptocurrency.data.remote.dto.CoinDetailDto
import com.ashana.ui.model.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}
package com.ashana.ui.model.cryptocurrency.data.repository

import com.ashana.ui.model.cryptocurrency.data.remote.MainApi
import com.ashana.ui.model.cryptocurrency.data.remote.dto.CoinDetailDto
import com.ashana.ui.model.cryptocurrency.data.remote.dto.CoinDto
import com.ashana.ui.model.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val mainApi: MainApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return mainApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return mainApi.getCoin(coinId = coinId)
    }
}
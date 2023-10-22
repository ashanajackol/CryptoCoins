package com.ashana.ui.model.cryptocurrency.data.remote

import com.ashana.ui.model.cryptocurrency.data.remote.dto.CoinDetailDto
import com.ashana.ui.model.cryptocurrency.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MainApi {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoin(@Path("coinId") coinId: String) : CoinDetailDto

}
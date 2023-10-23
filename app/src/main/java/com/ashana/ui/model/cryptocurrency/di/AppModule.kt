package com.ashana.ui.model.cryptocurrency.di

import com.ashana.ui.model.cryptocurrency.common.Constants
import com.ashana.ui.model.cryptocurrency.data.remote.MainApi
import com.ashana.ui.model.cryptocurrency.data.repository.CoinRepositoryImpl
import com.ashana.ui.model.cryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAPI(): MainApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MainApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: MainApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}
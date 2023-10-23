package com.ashana.ui.model.cryptocurrency.domain.use_case.get_coins

import android.net.http.HttpException
import android.os.Build
import android.os.ext.SdkExtensions
import com.ashana.ui.model.cryptocurrency.common.Resource
import com.ashana.ui.model.cryptocurrency.data.remote.dto.toCoin
import com.ashana.ui.model.cryptocurrency.domain.model.Coin
import com.ashana.ui.model.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(
                Build.VERSION_CODES.S) >= 7) {
            try {
                emit(Resource.Loading())
                val coin = repository.getCoins().map { it.toCoin() }
                emit(Resource.Success(coin))
            } catch (e: HttpException) {
                emit(Resource.Error(errorMessage = "An unexpected error occurred!"))
            } catch (e: IOException) {
                emit(Resource.Error(errorMessage = "Something went wrong, please try again later!"))
            }
        }
    }

}
package com.ashana.ui.model.cryptocurrency.domain.use_case.get_coin

import android.net.http.HttpException
import android.os.Build
import android.os.ext.SdkExtensions
import com.ashana.ui.model.cryptocurrency.common.Resource
import com.ashana.ui.model.cryptocurrency.data.remote.dto.toCoinDetail
import com.ashana.ui.model.cryptocurrency.domain.model.CoinDetail
import com.ashana.ui.model.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

import javax.inject.Inject

class GetCoinByIdUserCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(
                Build.VERSION_CODES.S) >= 7) {
            try {
                emit(Resource.Loading<CoinDetail>("Please wait..."))
                val coinDetail = repository.getCoinById(coinId = coinId).toCoinDetail()
                emit(Resource.Success<CoinDetail>(coinDetail))
            } catch (e: HttpException) {
                emit(Resource.Error<CoinDetail>(errorMessage = "An unexpected error occurred!"))
            } catch (e: IOException) {
                emit(Resource.Error<CoinDetail>(errorMessage = "Something went wrong, please try again later!"))
            }
        }
    }

}
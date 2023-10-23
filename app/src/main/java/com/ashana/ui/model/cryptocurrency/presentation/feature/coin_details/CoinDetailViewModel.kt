package com.ashana.ui.model.cryptocurrency.presentation.feature.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashana.ui.model.cryptocurrency.common.Resource
import com.ashana.ui.model.cryptocurrency.domain.use_case.get_coin.GetCoinByIdUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val coinDetailUseCase : GetCoinByIdUserCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _coinDetailState = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _coinDetailState

    init {
        savedStateHandle.get<String>("default_or_dummy_id")?.let { coinId ->
            getCoinDetails(coinId = coinId)
        }
    }

    private fun getCoinDetails(coinId: String) {
        coinDetailUseCase(coinId = coinId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _coinDetailState.value = CoinDetailState(success = result.successData, loading = false)
                }
                is Resource.Error -> {
                    _coinDetailState.value = CoinDetailState(error = result.errorMessage, loading = false)
                }
                is Resource.Loading -> {
                    _coinDetailState.value = CoinDetailState(loading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
package com.ashana.ui.model.cryptocurrency.presentation.feature.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashana.ui.model.cryptocurrency.common.Resource
import com.ashana.ui.model.cryptocurrency.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinListUseCase : GetCoinsUseCase
) : ViewModel() {

    private val _coinListState = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _coinListState

    init {
        getCoinList()
    }

    private fun getCoinList() {
        coinListUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _coinListState.value = CoinListState(success = result.successData, loading = false)
                }
                is Resource.Error -> {
                    _coinListState.value = CoinListState(error = result.errorMessage ?: "Something went wrong!", loading = false)
                }
                is Resource.Loading -> {
                    _coinListState.value = CoinListState(loading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
package com.ashana.ui.model.cryptocurrency.presentation.feature.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ashana.ui.model.cryptocurrency.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinListUseCase : GetCoinsUseCase
) : ViewModel() {

    private val _coinListState = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _coinListState


}
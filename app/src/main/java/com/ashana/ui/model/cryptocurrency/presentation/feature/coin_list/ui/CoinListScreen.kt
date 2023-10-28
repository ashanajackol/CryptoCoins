package com.ashana.ui.model.cryptocurrency.presentation.feature.coin_list.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ashana.ui.model.cryptocurrency.presentation.Screens
import com.ashana.ui.model.cryptocurrency.presentation.feature.coin_list.CoinListViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        val state = viewModel.state.value
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.success) { coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navController.navigate(Screens.CoinDetailsScreen.route + "/${coin.id}")
                    }
                )
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = Color.Red,
                textAlign = TextAlign.Center
            )
        }
        if (state.loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
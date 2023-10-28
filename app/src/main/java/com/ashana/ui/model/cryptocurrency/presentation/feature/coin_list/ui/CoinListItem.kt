package com.ashana.ui.model.cryptocurrency.presentation.feature.coin_list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ashana.ui.model.cryptocurrency.domain.model.Coin

@Composable
internal fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { onItemClick(coin) },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = if (coin.isActive) "Active" else "Inactive",
            color = if (coin.isActive) Color.Green else Color.Gray
        )
    }
}

@Preview
@Composable
private fun PreviewCoinListItem() {
    CoinListItem(
        coin = Coin(
            id = "1",
            name = "Bitcoin",
            isActive = true,
            rank = 1,
            symbol = "BTC"
        ),
        onItemClick = {})
}
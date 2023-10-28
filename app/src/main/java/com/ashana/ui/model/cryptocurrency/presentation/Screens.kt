package com.ashana.ui.model.cryptocurrency.presentation

sealed class Screens(val route: String) {
    object CoinListscreen : Screens(route = "coin_list_screen")
    object CoinDetailsScreen : Screens(route = "coin_details_screen")
}

package com.ashana.ui.model.cryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ashana.ui.model.cryptocurrency.presentation.feature.coin_details.ui.CoinDetailScreen
import com.ashana.ui.model.cryptocurrency.presentation.feature.coin_list.ui.CoinListScreen
import com.ashana.ui.model.cryptocurrency.presentation.theme.CryptoCurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrencyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.CoinListscreen.route
                    ) {
                        composable(
                            route = Screens.CoinListscreen.route
                        ) {
                            CoinListScreen(navController = navController)
                        }
                        composable(
                            route = Screens.CoinDetailsScreen.route
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
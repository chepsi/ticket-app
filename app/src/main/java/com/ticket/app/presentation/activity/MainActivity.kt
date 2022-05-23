package com.ticket.app.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ticket.app.presentation.screens.Screen
import com.ticket.app.presentation.screens.cart.CartScreen
import com.ticket.app.presentation.screens.shop.ShopScreen
import com.ticket.app.presentation.theme.TicketAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicketAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Shop.route
    ) {
        composable(route = Screen.Shop.route) {
            ShopScreen { navController.navigate(Screen.Cart.route) }
        }
        composable(route = Screen.Cart.route) {
            CartScreen()
        }
    }
}

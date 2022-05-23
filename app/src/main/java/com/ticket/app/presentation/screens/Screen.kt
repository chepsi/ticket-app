package com.ticket.app.presentation.screens

sealed class Screen(val route: String) {
    object Shop : Screen("shop")
    object Cart : Screen("cart")
}

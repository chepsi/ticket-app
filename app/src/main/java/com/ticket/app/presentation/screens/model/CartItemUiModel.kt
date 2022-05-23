package com.ticket.app.presentation.screens.model

data class CartItemUiModel(
    val name: String,
    val id: String,
    val description: String,
    val quantity: Int,
    val unitPrice: Double,
    val totalPrice: Double
)

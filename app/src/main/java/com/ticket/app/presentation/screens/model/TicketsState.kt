package com.ticket.app.presentation.screens.model

sealed class TicketsState {
    object Loading : TicketsState()
    object Empty : TicketsState()
    data class Success(val data: List<TicketsUiModel>) : TicketsState()
}

sealed class CartItemsState {
    object Loading : CartItemsState()
    object Empty : CartItemsState()
    data class Success(val data: List<CartItemUiModel>) : CartItemsState()
}

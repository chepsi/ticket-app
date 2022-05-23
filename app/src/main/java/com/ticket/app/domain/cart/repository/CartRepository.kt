package com.ticket.app.domain.cart.repository

import com.ticket.app.presentation.screens.model.CartItemUiModel
import com.ticket.app.presentation.screens.model.TicketsUiModel
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    suspend fun saveCartItem(request: TicketsUiModel): Flow<Boolean>

    suspend fun fetchCartItems(): Flow<List<CartItemUiModel>>
}

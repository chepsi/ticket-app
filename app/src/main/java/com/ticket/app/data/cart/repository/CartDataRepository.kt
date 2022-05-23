package com.ticket.app.data.cart.repository

import com.ticket.app.domain.cart.repository.CartRepository
import com.ticket.app.presentation.screens.model.CartItemUiModel
import com.ticket.app.presentation.screens.model.TicketsUiModel
import kotlinx.coroutines.flow.flow

class CartDataRepository : CartRepository {
    override suspend fun saveCartItem(request: TicketsUiModel) = flow {
        emit(true)
    }

    override suspend fun fetchCartItems() = flow {
        emit(
            listOf(
                CartItemUiModel(
                    name = "Some play",
                    id = "1",
                    description = "Some cool play",
                    1,
                    10.00,
                    10.00
                ),
                CartItemUiModel(
                    name = "Some act",
                    id = "2",
                    description = "Some romantic act",
                    2,
                    20.00,
                    40.00
                ),
                CartItemUiModel(
                    name = "Some movie",
                    id = "3",
                    description = "Some horror movie",
                    2,
                    50.00,
                    100.00
                )
            )
        )
    }
}

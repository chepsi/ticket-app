package com.ticket.app.presentation.screens.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ticket.app.domain.cart.repository.CartRepository
import com.ticket.app.presentation.screens.model.CartItemsState
import com.ticket.app.presentation.screens.model.CartItemsState.Empty
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CartViewModel(
    private val cartRepository: CartRepository,
) : ViewModel() {

    private val _cartItems = MutableStateFlow<CartItemsState>(Empty)
    val cartItems: StateFlow<CartItemsState> get() = _cartItems

    fun fetchItems() {
        viewModelScope.launch {
            cartRepository.fetchCartItems().collectLatest {
                _cartItems.value = CartItemsState.Success(it)
            }
        }
    }
}

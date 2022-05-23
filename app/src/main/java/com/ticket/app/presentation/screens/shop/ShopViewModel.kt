package com.ticket.app.presentation.screens.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ticket.app.domain.cart.repository.CartRepository
import com.ticket.app.domain.tickets.repository.TicketsRepository
import com.ticket.app.presentation.screens.model.TicketsState
import com.ticket.app.presentation.screens.model.TicketsState.Empty
import com.ticket.app.presentation.screens.model.TicketsUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ShopViewModel(
    private val cartRepository: CartRepository,
    private val ticketsRepository: TicketsRepository
) : ViewModel() {

    private val _tickets = MutableStateFlow<TicketsState>(Empty)
    val tickets: StateFlow<TicketsState> get() = _tickets

    fun addItems(request: TicketsUiModel) {
        viewModelScope.launch {
            cartRepository.saveCartItem(request)
        }
    }

    fun fetchItems() {
        _tickets.value = TicketsState.Loading
        viewModelScope.launch {
            ticketsRepository.fetchTickets().collectLatest {
                _tickets.value = TicketsState.Success(it)
            }
        }
    }
}

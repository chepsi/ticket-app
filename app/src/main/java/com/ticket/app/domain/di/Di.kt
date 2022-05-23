package com.ticket.app.domain.di

import com.ticket.app.data.cart.repository.CartDataRepository
import com.ticket.app.data.tickets.repository.TicketsDataRepository
import com.ticket.app.domain.cart.repository.CartRepository
import com.ticket.app.domain.tickets.repository.TicketsRepository
import com.ticket.app.presentation.screens.cart.CartViewModel
import com.ticket.app.presentation.screens.shop.ShopViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory<TicketsRepository> { TicketsDataRepository() }
    factory<CartRepository> { CartDataRepository() }

    viewModel { CartViewModel(get()) }
    viewModel { ShopViewModel(get(), get()) }
}

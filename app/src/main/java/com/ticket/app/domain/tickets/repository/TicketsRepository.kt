package com.ticket.app.domain.tickets.repository

import com.ticket.app.presentation.screens.model.TicketsUiModel
import kotlinx.coroutines.flow.Flow

interface TicketsRepository {
    suspend fun fetchTickets(): Flow<List<TicketsUiModel>>
}

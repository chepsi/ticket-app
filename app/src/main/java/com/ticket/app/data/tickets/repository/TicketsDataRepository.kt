package com.ticket.app.data.tickets.repository

import com.ticket.app.domain.tickets.repository.TicketsRepository
import com.ticket.app.presentation.screens.model.TicketsUiModel
import kotlinx.coroutines.flow.flow

class TicketsDataRepository : TicketsRepository {
    override suspend fun fetchTickets() = flow {
        emit(
            listOf(
                TicketsUiModel(id = "1", "SomeMovie", 10.00),
                TicketsUiModel(id = "2", "SomePlay", 15.00),
                TicketsUiModel(id = "3", "SomeAct", 20.00)
            )
        )
    }
}

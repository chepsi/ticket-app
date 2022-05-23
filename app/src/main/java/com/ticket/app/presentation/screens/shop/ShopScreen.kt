package com.ticket.app.presentation.screens.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ticket.app.presentation.screens.model.TicketsState.Empty
import com.ticket.app.presentation.screens.model.TicketsState.Loading
import com.ticket.app.presentation.screens.model.TicketsState.Success
import com.ticket.app.presentation.screens.model.TicketsUiModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ShopScreen(navigate: () -> Unit) {
    val viewModel: ShopViewModel = getViewModel()
    viewModel.fetchItems()

    when (val data = viewModel.tickets.collectAsState().value) {
        is Success -> DisplayShoppingItems(data.data, navigate, viewModel)
        Empty -> Unit
        Loading -> CircularProgressIndicator()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayShoppingItems(
    data: List<TicketsUiModel>,
    navigate: () -> Unit,
    viewModel: ShopViewModel
) {
    Column {
        LazyColumn(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(10.dp)) {
            items(items = data, itemContent = { ticket ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    onClick = {
                        viewModel.addItems(ticket)
                    }
                ) {
                    Column {
                        Text(text = ticket.name)
                        Text(text = ticket.price.toString())
                    }
                }
            })
        }

        Button(onClick = { navigate() }) {
            Text(text = "Check Out")
        }
    }
}

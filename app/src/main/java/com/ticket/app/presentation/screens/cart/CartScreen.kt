package com.ticket.app.presentation.screens.cart

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
import com.ticket.app.presentation.screens.model.CartItemUiModel
import com.ticket.app.presentation.screens.model.CartItemsState.Empty
import com.ticket.app.presentation.screens.model.CartItemsState.Loading
import com.ticket.app.presentation.screens.model.CartItemsState.Success
import org.koin.androidx.compose.getViewModel

@Composable
fun CartScreen() {
    val viewModel: CartViewModel = getViewModel()
    viewModel.fetchItems()

    when (val data = viewModel.cartItems.collectAsState().value) {
        is Success -> DisplayCartItems(data.data)
        Empty -> Unit
        Loading -> CircularProgressIndicator()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayCartItems(data: List<CartItemUiModel>) {
    Column {
        Text(text = "Your Items")

        LazyColumn(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(10.dp)) {
            items(items = data, itemContent = { cartItem ->
                Card(shape = RoundedCornerShape(8.dp)) {
                    Column {
                        Text(text = cartItem.name)
                        Text(text = cartItem.description)
                        Text(text = "${cartItem.quantity} | ${cartItem.unitPrice} each")
                    }
                }
            })
        }

        Text(text = "Subtotal: $ ${data.sumOf { it.totalPrice }}")

        Button(onClick = { }) {
            Text(text = "Go To Checkout")
        }
    }
}

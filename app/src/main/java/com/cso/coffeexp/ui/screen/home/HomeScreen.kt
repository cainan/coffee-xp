package com.cso.coffeexp.ui.screen.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cso.coffeexp.ui.components.SwipeToDeleteCoffee
import com.cso.coffeexp.ui.mock.mockCoffeeData
import com.cso.coffeexp.ui.theme.CoffeeXpTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUIState,
    onEvent: (HomeEvent) -> Unit = {},
    onNavigateToDetails: (Long?) -> Unit = {},
) {
    LaunchedEffect(Unit) {
        onEvent(HomeEvent.OnInit)
    }

    val context = LocalContext.current
    val coffeeList = uiState.coffeeList

    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onNavigateToDetails(null)
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Add new coffee")
            }
        }
    ) { innerPadding ->
        if (coffeeList.isNullOrEmpty()) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No coffees yet. Add one with the + button!")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items = coffeeList, key = { it.id ?: 0 }) { coffee ->
                    SwipeToDeleteCoffee(
                        coffee = coffee,
                        onToggleDone = {
                            Toast.makeText(context, "onToggleDone", Toast.LENGTH_SHORT).show()
                        },
                        onRemove = {
                            onEvent(HomeEvent.OnRemoveCoffee(it))
                        },
                        onClick = { coffee ->
                            onNavigateToDetails(coffee.id)
                        },
                        modifier = Modifier.animateItem()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CoffeeXpTheme {
        HomeScreen(
            uiState = HomeUIState(coffeeList = mockCoffeeData),
        )
    }
}

@Preview(showBackground = true, name = "Coffee Screen Empty")
@Composable
fun HomeScreenEmptyPreview() {
    CoffeeXpTheme {
        // Simulate an empty list for this preview
        HomeScreen(
            uiState = HomeUIState(),
        )
    }
}
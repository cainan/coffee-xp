package com.cso.coffeexp.ui.screen.home

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cso.coffeexp.data.Coffee
import com.cso.coffeexp.ui.components.CoffeeCard
import com.cso.coffeexp.ui.mock.getSampleCoffeeData
import com.cso.coffeexp.ui.theme.CoffeeXpTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, coffeeList: List<Coffee> = emptyList()) {
    // This would typically come from a ViewModel
    var coffeeList by remember { mutableStateOf(coffeeList) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // TODO: Implement navigation to an "Add Coffee" screen or show a dialog
                // For now, let's add a sample coffee
                val newCoffee = Coffee(
                    name = "New Roast ${coffeeList.size + 1}",
                    method = "Pour Over",
                    grade = 4.5f
                )
                coffeeList = coffeeList + newCoffee
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Add new coffee")
            }
        }
    ) { innerPadding ->
        if (coffeeList.isEmpty()) {
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
                items(coffeeList, key = { it.id }) { coffee ->
                    CoffeeCard(coffee = coffee)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CoffeeXpTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true, name = "Coffee Screen Empty")
@Composable
fun HomeScreenEmptyPreview() {
    CoffeeXpTheme {
        // Simulate an empty list for this preview
        HomeScreen(
            modifier = Modifier,
            coffeeList = getSampleCoffeeData()
        )
    }
}
package com.cso.coffeexp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cso.coffeexp.ui.mock.getSampleCoffeeData
import com.cso.coffeexp.ui.screen.coffee.CoffeeScreen
import com.cso.coffeexp.ui.theme.CoffeeXpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeXpTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoffeeScreen(
                        modifier = Modifier.padding(innerPadding),
                        coffeeList = getSampleCoffeeData()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        CoffeeScreen(
            modifier = Modifier.padding(innerPadding),
            coffeeList = getSampleCoffeeData()
        )
    }
}
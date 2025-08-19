package com.cso.coffeexp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cso.coffeexp.ui.screen.nav_host.MainNavHost
import com.cso.coffeexp.ui.theme.CoffeeXpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeXpTheme {
                MainNavHost()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoffeeXpTheme {
        CoffeeXpTheme {
            MainNavHost()
        }
    }
}
package com.cso.coffeexp.ui.screen.nav_host

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cso.coffeexp.ui.mock.getSampleCoffeeData
import com.cso.coffeexp.ui.screen.home.HomeScreen
import com.cso.coffeexp.ui.theme.CoffeeXpTheme

@Composable
fun MainNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(modifier = modifier, navController = navController, startDestination = UIRoute.Home) {
        composable<UIRoute.Home> {
            HomeScreen(
                modifier = Modifier,
                coffeeList = getSampleCoffeeData()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainNavHostPreview() {
    CoffeeXpTheme {
        MainNavHost()
    }
}
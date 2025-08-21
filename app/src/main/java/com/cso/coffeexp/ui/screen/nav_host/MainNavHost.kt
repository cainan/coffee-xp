package com.cso.coffeexp.ui.screen.nav_host

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cso.coffeexp.ui.mock.getSampleCoffeeData
import com.cso.coffeexp.ui.screen.details.DetailsScreen
import com.cso.coffeexp.ui.screen.details.DetailsUIState
import com.cso.coffeexp.ui.screen.home.HomeScreen
import com.cso.coffeexp.ui.screen.home.HomeUIState
import com.cso.coffeexp.ui.theme.CoffeeXpTheme

private const val TAG = "MainNavHost"

@Composable
fun MainNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(modifier = modifier, navController = navController, startDestination = UIRoute.Home) {

        composable<UIRoute.Home> {
            HomeScreen(
                modifier = Modifier,
                uiState = HomeUIState(coffeeList = getSampleCoffeeData()),
                onNavigateToDetails = { coffee ->
                    Log.d(TAG, "Coffee: $coffee")
                    navController.navigate(UIRoute.Details("coffee"))
                }
            )
        }

        composable<UIRoute.Details> { navBackStackEntry ->
//            val coffee: Coffee = navBackStackEntry.toRoute()
//            val coffeeId = navBackStackEntry.arguments?.getString(UIArgument.COFFEE.key)
//            Log.d(TAG, "Coffee ID: $coffeeId")
            val coffee = getSampleCoffeeData()[0]

            DetailsScreen(
                modifier = Modifier,
                uiState = DetailsUIState(coffee = coffee),
                onBackPressed = { navController.popBackStack() },
                onSaveCoffee = { TODO() }
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
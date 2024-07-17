package com.example.legoshop.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.legoshop.presentation.home.HomeDestination
import com.example.legoshop.presentation.home.HomeScreen
import com.example.legoshop.presentation.itemdetails.ItemDetailScreen
import com.example.legoshop.presentation.itemdetails.ItemDetailsDestination

@Composable
fun ShopNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToItemDetails = { navController.navigate(ItemDetailsDestination.route) }
            )
        }

        composable(route = ItemDetailsDestination.route) {
            ItemDetailScreen()
        }
    }
}
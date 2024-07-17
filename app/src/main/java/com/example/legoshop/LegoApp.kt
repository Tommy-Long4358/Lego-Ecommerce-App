package com.example.legoshop

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.legoshop.presentation.navigation.ShopNavHost

@Composable
fun LegoApp(navController: NavHostController = rememberNavController()) {
    ShopNavHost(navController = navController)
}
package com.example.mygoods.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mygoods.screens.FormProductScreen
import com.example.mygoods.screens.ProductsListScreen

@Composable
fun AppNav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "productsList"){
        composable ("productsList"){
            ProductsListScreen(navController)
        }
        composable("formProduct"){
            FormProductScreen(navController)
        }

    }
}
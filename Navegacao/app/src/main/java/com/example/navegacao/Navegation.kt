package com.example.navegacao

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navegacao.ui.screen.ScreenOne
import com.example.navegacao.ui.screen.SecondScreen
import com.example.navegacao.ui.screen.ThirdScreen

@Composable
fun Navigation(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen_one") {
        composable("screen_one") { ScreenOne(modifier=modifier,navController) }
        composable("screen_two") { SecondScreen(modifier=modifier,navController) }
        composable("screen_three") { ThirdScreen(modifier=modifier,navController) }
    }
}

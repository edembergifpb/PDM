package com.example.navegacao.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ScreenOne(modifier: Modifier, navController: NavController){
    Topo(modifier = modifier, titulo = "Tela 1")
    Column (modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Button(onClick = {
            navController.navigate("screen_two")
        }) {
            Text(text = "Ir para tela 2")
        }
    }
}
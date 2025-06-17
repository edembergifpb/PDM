package com.example.navegacao.ui.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ThirdScreen(modifier: Modifier, navController: NavController){
    Topo(modifier = modifier, titulo = "Tela 3")
    Row (modifier = modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center){
        Button(onClick = {
            navController.navigate("screen_two")
        }) {
            Text(text = "Voltar")
        }
        Button(onClick = {
            navController.navigate("screen_one")
        }) {
            Text(text = "Voltar para tela 1")
        }
    }
}
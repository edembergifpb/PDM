package com.example.navegationproject.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Screen(modifier: Modifier = Modifier, text: String, color:Color){
    Box (modifier = modifier.fillMaxSize()
        .background(color)){
        Text(text, color = Color.White, modifier = Modifier.align(Alignment.Center),
            fontWeight = FontWeight.Bold, fontSize = 30.sp)
    }
}
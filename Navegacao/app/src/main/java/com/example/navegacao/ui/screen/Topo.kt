package com.example.navegacao.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Topo(modifier: Modifier, titulo: String){
    Box(modifier = modifier.fillMaxWidth().height(80.dp).background(Color.Blue)){
        Text(text = titulo, modifier = modifier.align(Alignment.Center,),
            fontStyle = FontStyle.Italic, color = Color.White,
            fontSize = 20.sp)
    }
}
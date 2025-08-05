package com.example.contadorapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contadorapp.viewmodel.ContadorViewModel

@Composable
fun CountScreen(modifier: Modifier = Modifier,
                viewModel: ContadorViewModel = viewModel()) {
    val state = viewModel.contador.collectAsState()

    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(text = "${state.value}", fontSize = 50.sp, fontWeight = FontWeight.Bold)
        Row {
            IconButton(onClick = { viewModel.incrementarContador() }){
                Icon(imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = null,
                    Modifier.size(70.dp))
            }
            IconButton(onClick = { viewModel.decrementarContador() }){
                Icon(imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    Modifier.size(70.dp)
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountScreenPreview(){
    CountScreen(modifier = Modifier)
}
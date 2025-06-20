package com.example.lojahortfruit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import com.example.lojahortfruit.dados.ListaDeProdutosPorColuna
import com.example.lojahortfruit.dados.SearchBar
import com.example.lojahortfruit.dados.geraDados
import com.example.lojahortfruit.ui.theme.LojaHortfruitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            LojaHortfruitTheme {
                SearchBar(geraDados(), modifier = Modifier)
            }
        }
    }
}
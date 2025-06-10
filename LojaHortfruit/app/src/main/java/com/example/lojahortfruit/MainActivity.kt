package com.example.lojahortfruit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lojahortfruit.dados.MainScreen
import com.example.lojahortfruit.ui.theme.LojaHortfruitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            LojaHortfruitTheme {
                MainScreen()
            }
        }
    }
}
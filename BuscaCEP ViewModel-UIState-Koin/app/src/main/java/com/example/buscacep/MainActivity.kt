package com.example.buscacep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.buscacep.ui.theme.BuscaCEPTheme
import com.example.buscacep.viewmodels.EnderecoViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuscaCEPTheme {
                val viewModel = koinViewModel<EnderecoViewModel>()
                CEPScreen(viewModel)
            }
        }
    }
}
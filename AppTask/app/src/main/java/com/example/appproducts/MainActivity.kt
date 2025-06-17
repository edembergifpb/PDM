package com.example.appproducts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appproducts.model.ProdutoDao
import com.example.appproducts.screens.ProdutoApp
import com.example.appproducts.ui.theme.AppTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTaskTheme {
                ProdutoApp()
            }
        }
    }
}




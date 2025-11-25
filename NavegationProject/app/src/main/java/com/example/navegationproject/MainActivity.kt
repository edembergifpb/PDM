package com.example.navegationproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navegationproject.ui.screens.Screen
import com.example.navegationproject.ui.theme.NavegationProjectTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegationProjectTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentRoute = navBackStackEntry?.destination?.route
                            NavigationBarItem(
                                onClick = {
                                    navController.navigate("1")
                                },
                                label = { Text(text = "Um") },
                                selected = currentRoute == "1",
                                icon = { Icon(Icons.Default.Call, contentDescription = null) }
                            )
                            NavigationBarItem(
                                onClick = {
                                    navController.navigate("2")
                                },
                                label = { Text(text = "Dois") },
                                selected = currentRoute == "2",
                                icon = { Icon(Icons.Default.Create, contentDescription = null) }
                            )
                            NavigationBarItem(
                                onClick = {
                                    navController.navigate("3")
                                },
                                label = { Text(text = "Tres") },
                                selected = currentRoute == "3",
                                icon = { Icon(Icons.Default.Email, contentDescription = null) }
                            )
                        }
                    }) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "1",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("1") { Screen(Modifier.padding(innerPadding),"Um",Color.Blue) }
                        composable("2") { Screen(Modifier.padding(innerPadding),"Dois",Color.Red) }
                        composable("3") { Screen(Modifier.padding(innerPadding),"Tres",Color.Green) }
                    }
                }
            }
        }
    }
}

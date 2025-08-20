package com.example.mygoods.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.mygoods.viewmodels.ProductViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductsListScreen(navController: NavController){
    val viewModel: ProductViewModel = koinViewModel<ProductViewModel>()
    val state = viewModel.listuiState.collectAsState()
    Scaffold (topBar = {
        TopAppBar(title = { Text("Products List") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("formProduct")
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add Product")
            }
        }) {paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                if (state.value.isLoading) {
                    Text(text = "Carregando...")
                } else if (state.value.error != null) {
                    Text(text = "Erro: ${state.value.error}", color = Color.Red)
                } else if (state.value.products.isEmpty()) {
                    Text(text = "Sem produtos!", color = Color.Red)
                }else{
                    LazyColumn{
                            items(state.value.products.size){ index ->
                                val product = state.value.products[index]
                                Row {
                                    Text(text = product.name)
                                    Text(text = product.price.toString())
                                }
                            }
                    }
                }
            }


        //when(state){
            //Loading
            //Empty
            //Error
            //Success is
            //{
                /*LazyColumn(modifier = Modifier.fillMaxSize()){
                    items(products.size){ index ->
                        val product = products[index]
                        Text(text = product.name)
                    }
                }*/
            //}
        //}
    }
}
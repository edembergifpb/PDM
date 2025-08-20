package com.example.mygoods.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.mygoods.viewmodels.ProductViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FormProductScreen(navController: NavController){
    val viewModel: ProductViewModel = koinViewModel<ProductViewModel>()
    val state = viewModel.formUiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(value = state.value.name,
            onValueChange = {
                viewModel.changeName(it)
            },
            label = {Text("Name")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii))
        OutlinedTextField(value = state.value.price.toString(),
            onValueChange = {
                viewModel.changePrice(it)
            },
            label = {Text("Price")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        Row (verticalAlignment = Alignment.CenterVertically){
            Button(onClick = {
                viewModel.saveProduct(state.value.name,
                    state.value.price)
                navController.navigate("productsList")
                },
                enabled = state.value.isNameValid && state.value.isPriceValid
            ) {
                Text(text = "Save")
                Log.d("FormProductScreen", "Daddos: ${state.value.name} ${state.value.isNameValid}")
                Log.d("FormProductScreen", "Daddos: ${state.value.price} ${state.value.isPriceValid}")

            }
            Button(
                onClick = {
                    navController.navigate("productsList")
                }) {
                Text(text = "Cancel")
            }
        }
    }
}
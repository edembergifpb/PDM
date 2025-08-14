package com.example.buscacep

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HourglassEmpty
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.buscacep.viewmodels.EnderecoViewModel
import com.example.buscacep.viewmodels.CepUIState

@Composable
fun CEPScreen(viewModel: EnderecoViewModel) {
    var cep by remember { mutableStateOf("") }
    val state by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.padding(top = 60.dp), verticalArrangement = Arrangement.Center){
        Row {
            TextField(
                value = cep,
                onValueChange = { cep = it },
                label = { Text("Digite aqui CEP") })
            Button(
                onClick = {
                    viewModel.buscarEndereco(cep)
                }
            ) {
                Text(text = "Buscar")
            }
        }

        when(state) {
            is CepUIState.Idle -> {
                Text(text = "Digite um CEP")
            }
            is CepUIState.Loading -> {
                Text(text = "Carregando...")
            }
            is CepUIState.Success -> {
                val endereco = (state as CepUIState.Success).data
                Text(text = "Logradouro:")
                TextField (value = endereco.logradouro.toString(), onValueChange = {}, enabled =
                    false)
                Text(text = "Bairro: ")
                TextField(value = endereco.bairro.toString(), onValueChange = {}, enabled = false)
            }
            is CepUIState.Error -> {
                Toast.makeText(LocalContext.current, (state as CepUIState.Error).message, Toast.LENGTH_LONG).show()
            }
        }

    }
}
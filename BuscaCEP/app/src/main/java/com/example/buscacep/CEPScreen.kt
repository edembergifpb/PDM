package com.example.buscacep

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.buscacep.clientservice.EnderecoClient
import com.example.buscacep.model.Endereco
import kotlinx.coroutines.launch

@Composable
fun CEPScreen() {
    Column(modifier = Modifier.padding(top = 60.dp), verticalArrangement = Arrangement.Center){
        var cep by remember { mutableStateOf("") }
        val scope = rememberCoroutineScope()
        var endereco by remember { mutableStateOf(Endereco()) }

        Row {
            TextField(
                value = cep,
                onValueChange = { cep = it },
                label = { Text("Digite aqui CEP") })
            Button(
                onClick = {
                    scope.launch {
                            endereco = EnderecoClient.enderecoAPI.getEnderecoByCEP(cep)
                    }
                }
            ) {
                Text(text = "Buscar")
            }
        }
        Text(text = "Logradouro:")
        TextField(value = endereco.logradouro.toString(), onValueChange = {}, enabled = false)

        Text(text = "Bairro: ")
        TextField(value = endereco.bairro.toString(), onValueChange = {}, enabled = false)


    }
}
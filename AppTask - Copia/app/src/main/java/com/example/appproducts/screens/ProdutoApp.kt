package com.example.appproducts.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.appproducts.model.Produto
import com.example.appproducts.model.ProdutoDao
import kotlinx.coroutines.launch

@Composable
fun ProdutoApp() {
    val context = LocalContext.current
    val repo = remember { ProdutoDao() }
    val scope = rememberCoroutineScope()

    var nome by remember { mutableStateOf("") }
    var preco by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }
    var listaProdutos by remember { mutableStateOf(listOf<Produto>()) }

    LaunchedEffect(Unit) {
        listaProdutos = repo.listarProdutos()
    }

    Column(modifier = Modifier.padding(top = 60.dp, start = 16.dp, end = 16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Cadastro de Produto", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome do produto") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = preco,
            onValueChange = { preco = it },
            label = { Text(text = "Preço do produto") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val precoDouble = preco.toDoubleOrNull() ?: 0.0
                scope.launch {
                    repo.adicionarProduto(Produto(nome, precoDouble))
                    listaProdutos = repo.listarProdutos()
                    nome = ""
                    preco = ""
                    mensagem="Produto adicionado com sucesso!"
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Salvar Produto")
        }

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        Text("Lista de Produtos", style = MaterialTheme.typography.titleLarge)

        LazyColumn (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 40.dp)
        ) {

            items(listaProdutos){ produto ->
                ProdutoCard(produto) {produto ->
                    scope.launch {
                        repo.remover(produto)
                        listaProdutos = repo.listarProdutos()
                        mensagem="Produto removido com sucesso!"
                    }
                }
            }
        }
    }
    if (!mensagem.equals("")) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
        mensagem = ""
    }
}
package com.example.appproducts.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.appproducts.model.Produto
import androidx.compose.material3.Icon

@Composable
fun ProdutoCard(
    produto: Produto,
    onRemoverConfirmado: (Produto) -> Unit
) {
    var mostrarDialog by remember { mutableStateOf(false) }

    if (mostrarDialog) {
        AlertDialog(
            onDismissRequest = { mostrarDialog = false },
            title = { Text("Remover Produto") },
            text = { Text("Tem certeza que deseja remover \"${produto.nome}\"?") },
            confirmButton = {
                TextButton(onClick = {
                    mostrarDialog = false
                    onRemoverConfirmado(produto)
                }) {
                    Text("Sim")
                }
            },
            dismissButton = {
                TextButton(onClick = { mostrarDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = produto.nome, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "R$ %.2f".format(produto.preco),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }

            IconButton(onClick = {
                mostrarDialog = true
            }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Remover Produto",
                    tint = Color.Red
                )
            }
        }
    }
}
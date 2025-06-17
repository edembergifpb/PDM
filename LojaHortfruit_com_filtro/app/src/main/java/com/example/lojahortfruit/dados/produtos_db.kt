package com.example.lojahortfruit.dados

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.lojahortfruit.R


data class Produto(
    val nome: String,
    val preco: Float,
    val imagemResId: Int
)

fun geraDados():ArrayList<Produto>{
    val produtos = ArrayList<Produto>()
    produtos.add(Produto(preco = 4.99F, nome = "Banana", imagemResId = R.drawable.ic_banana))
    produtos.add(Produto(preco = 9.99F, nome = "Uva", imagemResId = R.drawable.ic_uva))
    produtos.add(Produto(preco = 3.99F, nome = "Laranja", imagemResId = R.drawable.ic_laranja))
    produtos.add(Produto(preco = 10.99F, nome = "Maça", imagemResId = R.drawable.ic_maca))
    produtos.add(Produto(preco = 7.99F, nome = "Jaca", imagemResId = R.drawable.ic_jaca))
    produtos.add(Produto(preco = 8.99F, nome = "Ameixa", imagemResId = R.drawable.ic_ameixa))
    produtos.add(Produto(preco = 7.99F, nome = "Morango", imagemResId = R.drawable.ic_morango))
    produtos.add(Produto(preco = 5.99F, nome = "Abacaxi", imagemResId = R.drawable.ic_abacaxi))
    produtos.add(Produto(preco = 24.99F, nome = "Kiwi", imagemResId = R.drawable.ic_kiwi))
    produtos.add(Produto(preco = 11.99F, nome = "Pera", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 7.99F, nome = "Jambo", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 5.99F, nome = "Tomate", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 24.99F, nome = "Pessego", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 11.99F, nome = "Amora", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 4.99F, nome = "Banana", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 4.99F, nome = "Pitaya", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 9.99F, nome = "Uva", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 3.99F, nome = "Laranja", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 10.99F, nome = "Maça", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 7.99F, nome = "Jaca", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 8.99F, nome = "Ameixa", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 7.99F, nome = "Morango", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 5.99F, nome = "Abacaxi", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 24.99F, nome = "Kiwi", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 11.99F, nome = "Pera", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 7.99F, nome = "Jambo", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 5.99F, nome = "Tomate", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 24.99F, nome = "Pessego", imagemResId = R.drawable.ic_launcher_foreground))
    produtos.add(Produto(preco = 11.99F, nome = "Amora", imagemResId = R.drawable.ic_launcher_foreground))
    return produtos
}

@Composable
fun SeachBar(produtos: List<Produto>, modifier: Modifier){

    var textSearch by remember { mutableStateOf("") }

    OutlinedTextField(
        value = textSearch,
        onValueChange = {
            textSearch = it
        },
        modifier = modifier.height(56.dp).fillMaxSize().padding(start = 16.dp, end = 16.dp),
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        placeholder = {
            Text(text = "Pesquisar")
        })
    var produtos = produtos
    if (!textSearch.equals(""))
        produtos = produtos.filter { it.nome.contains(textSearch, ignoreCase = true) }
    ListaDeProdutosPorColuna(produtos, modifier)

}

@Composable
fun ListaDeProdutosPorColuna(produtos: List<Produto>, modifier: Modifier) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 56.dp, start = 16.dp)
    ) {
        items(produtos) { produto ->
            ItemProduto(produto)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ItemProduto(produto: Produto) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = produto.imagemResId),
            contentDescription = produto.nome,
            modifier = Modifier
                .size(80.dp)
                .padding(end = 16.dp),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(text = produto.nome, style = MaterialTheme.typography.titleMedium)
            Text(text = produto.preco.toString(), style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview
@Composable
fun ListaDeProdutosPorColunaPreview(){
    ListaDeProdutosPorColuna(geraDados(), modifier = Modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    var textSearch by remember { mutableStateOf("") }

    Scaffold (
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Copyright PDM/TSI",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ){
        innerPadding ->  SeachBar(geraDados(), Modifier.padding(innerPadding))
    }
}
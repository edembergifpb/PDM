package com.example.listadetarefasapp.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listadetarefasapp.viewmodel.TaskListViewModel

@Composable
fun TaskListScreen(viewModel: TaskListViewModel = viewModel()){
    val state by viewModel.uiState.collectAsState()

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(start = 40.dp, top = 50.dp)
    ){
        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            OutlinedTextField(value = state.task,
                onValueChange = {
                    viewModel.onChangeTask(it)
                },
                label = { Text("Nova Tarefa") })
            Button(
                onClick = {
                    viewModel.adicionar(state.task)
            }) {
                Text(text = "Add")
            }
        }
        Spacer(modifier = Modifier.padding(16.dp))

        when{
            state.tasks.isNotEmpty() -> {
                LazyColumn {
                    items(state.tasks.size){ index ->
                        Text(text = state.tasks[index])
                    }
                }
            }
            state.tasks.isEmpty() -> {
                Text(text = "Sem tarefas")
            }

        }

        if (state.error.isNotEmpty()==true) {
            Toast.makeText(LocalContext.current, state.error, Toast.LENGTH_LONG).show()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskListScreenPreview() {
    TaskListScreen()
}
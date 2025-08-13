package com.example.listadetarefasapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class TaskListUIState(
    var tasks: List<String> = emptyList(),
    var task: String = "",
    var error: String = ""
)

class TaskListViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(TaskListUIState())
    val uiState:StateFlow<TaskListUIState> = _uiState

    fun adicionar(task: String){

        if (task.isEmpty()) {
            _uiState.value = _uiState.value.copy(
                error = "Informe uma tarefa "
            )
        } else if (_uiState.value.tasks.contains(task)) {
            _uiState.value = _uiState.value.copy(
                error = "Tarefa já existe"
            )
        } else {
            _uiState.value = _uiState.value.copy(
                tasks = _uiState.value.tasks.plus(task),
                error = ""
            )
        }
    }

    fun onChangeTask(string: String) {
        _uiState.value = _uiState.value.copy(task = string, error = "")
    }
}
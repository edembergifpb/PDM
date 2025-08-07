package com.example.buscacep.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buscacep.clientservice.CepRepository
import com.example.buscacep.model.Endereco
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class CepUIState {
    object Idle : CepUIState()
    data class Success(val data: Endereco) : CepUIState()
    data class Error (val message: String? = null): CepUIState()
    object Loading : CepUIState()
}

class EnderecoViewModel: ViewModel() {
    private val repository = CepRepository()

    private val _uiState = MutableStateFlow<CepUIState>(CepUIState.Idle)
    val uiState: StateFlow<CepUIState> = _uiState

    fun buscarEndereco(cep: String) {
        viewModelScope.launch {
            _uiState.value = CepUIState.Loading
            val result = repository.getEnderecoByCEP(cep)
            _uiState.value = result.fold(
                onSuccess = { CepUIState.Success(it) },
                onFailure = { CepUIState.Error(it.message?:"Erro desconhecido") }
            )
        }
    }
}
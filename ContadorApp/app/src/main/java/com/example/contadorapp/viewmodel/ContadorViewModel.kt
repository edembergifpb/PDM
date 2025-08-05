package com.example.contadorapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContadorViewModel: ViewModel() {
    private val _contador = MutableStateFlow(0)
    val contador: StateFlow<Int> = _contador.asStateFlow()

    fun incrementarContador(){
        _contador.value++
    }

    fun decrementarContador(){
        _contador.value--
    }

}
package com.example.mygoods.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygoods.data.ProductEntity
import com.example.mygoods.data.ProductRepository
import com.example.mygoods.uistates.FormProductUiState
import com.example.mygoods.uistates.ProductListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository): ViewModel() {
    private val _listUiState = MutableStateFlow(ProductListUiState())
    val listuiState: StateFlow<ProductListUiState> = _listUiState

    private val _formUiState = MutableStateFlow(FormProductUiState())
    val formUiState: StateFlow<FormProductUiState> = _formUiState

    init {
        loadProducts()
    }

    fun loadProducts(){
        viewModelScope.launch {
            _listUiState.value = _listUiState.value.copy(isLoading = true)
            try {
                val products = repository.getAllProducts()
                _listUiState.value = _listUiState.value.copy(products = products, isLoading = false, error = null)
            }catch (e: Exception) {
                _listUiState.value = _listUiState.value.copy(isLoading = false, error = e.message)
            }
        }
    }

    fun saveProduct(name: String, price: String){
        viewModelScope.launch {
            val price = price.toDoubleOrNull()?: 0.0
            Log.d("ProductViewModel", "Antes do IF saveProduct: $name $price")
            if (name.isBlank()|| price <= 0) {
                _formUiState.value = _formUiState.value.copy(
                    error = "Nome e/ou preço inválidos",
                )
                Log.d("ProductViewModel", "no IF saveProduct: $name $price")
            }else {
                try {
                    repository.insertProduct(ProductEntity(name = name, price = price))
                } catch (e: Exception) {
                    _formUiState.value = _formUiState.value.copy(
                        error = e.message
                    )
                }
                _formUiState.value = _formUiState.value.copy(
                    error = null
                )
            }
        }
    }

    fun changeName(name: String){
        if (name.isBlank()) {
            _formUiState.value = _formUiState.value.copy(
                isNameValid = false
            )
        }else {
            _formUiState.value = _formUiState.value.copy(name = name,
                isNameValid = true)
        }
    }
    fun changePrice(price: String){
        val preco = price.toDoubleOrNull()?: 0.0
        if (preco <= 0) {
            _formUiState.value = _formUiState.value.copy(
                isPriceValid = false
            )
        }
        else {
            _formUiState.value = _formUiState.value.copy(price = price,
                isPriceValid = true)
        }
    }
}
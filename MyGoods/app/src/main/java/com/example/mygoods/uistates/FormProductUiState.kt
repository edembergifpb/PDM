package com.example.mygoods.uistates

data class FormProductUiState(
    val name: String = "",
    val price: String = "",
    val error: String? = null,
    val isPriceValid: Boolean = false,
    val isNameValid: Boolean = false
)

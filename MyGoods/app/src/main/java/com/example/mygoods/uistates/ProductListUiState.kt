package com.example.mygoods.uistates

import com.example.mygoods.data.ProductEntity

data class ProductListUiState(
    val isLoading: Boolean = false,
    val products: List<ProductEntity> = emptyList(),
    val error: String? = null,
    val isIdle: Boolean = false
)

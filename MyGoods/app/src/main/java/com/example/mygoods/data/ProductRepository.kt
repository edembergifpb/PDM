package com.example.mygoods.data

class ProductRepository(private val productDao: ProductDao) {
    suspend fun getAllProducts(): List<ProductEntity> {
        return productDao.getAllProducts()
    }
    suspend fun getProductById(id: Int): ProductEntity? {
        return productDao.getProductById(id)
    }
    suspend fun insertProduct(product: ProductEntity) {
        productDao.insertProduct(product)
    }
    suspend fun deleteProduct(product: ProductEntity) {
        productDao.deleteProduct(product)
    }
}
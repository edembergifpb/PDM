package com.example.appproducts.model

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.firestore.toObjects
import kotlinx.coroutines.tasks.await

class ProdutoDao {
    private val db = FirebaseFirestore.getInstance()

    suspend fun adicionarProduto(produto: Produto):String? {
        return try {
            val result = db.collection("produtos")
                .add(produto)
                .await()

            println("Produto adicionado com sucesso!")

            result.id

        } catch (e: Exception) {
            println("Erro ao adicionar produto: $e")
            null
        }
    }

    suspend fun listarProdutos(): List<Produto> {
        return try {
            val result = db.collection("produtos")
                .get()
                .await()

            result.toObjects<Produto>()

        } catch (e: Exception) {
            println("Erro ao listar produtos: $e")
            emptyList()
        }
    }

    suspend fun remover(produto: Produto):Produto? {
        return try {

            db.collection("produtos")
                .document(produto.id)
                .delete()
                .await()

            produto

        } catch (e: Exception) {
            println("Erro ao remover o produto ${produto}: $e")
            null
        }
    }

    suspend fun getProdutoById(id: String):Produto? {
        return try {
            val result = db.collection("produtos")
                .document(id)
                .get()
                .await()

            if (result.exists()) {
                result.toObject<Produto>()
            } else {
                null
            }

        } catch (e: Exception) {
            println("Erro ao buscar o produto $id: $e")
            null
        }
    }

}
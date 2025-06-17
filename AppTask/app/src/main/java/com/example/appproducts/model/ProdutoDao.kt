package com.example.appproducts.model

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.firestore.toObjects
import kotlinx.coroutines.tasks.await

class ProdutoDao {
    private val db = FirebaseFirestore.getInstance()

    suspend fun adicionarProduto(produto: Produto) {
        db.collection("produtos")
            .add(produto)
            .addOnSuccessListener {
                println("Produto adicionado com sucesso!")
            }
            .addOnFailureListener { e ->
                println("Erro ao adicionar produto: $e")
            }.await()
    }

    suspend fun listarProdutos(): List<Produto> {
        var produtos: List<Produto> = ArrayList<Produto>()
        db.collection("produtos")
            .get()
            .addOnSuccessListener { result ->
                produtos = result.toObjects<Produto>()
            }
            .addOnFailureListener { e ->
                println("Erro ao listar produtos: $e")
            }.await()
        return produtos
    }

    suspend fun remover(produto: Produto) {
        db.collection("produtos")
            .document(produto.id)
            .delete()
            .addOnSuccessListener { result ->
                println("Produto adicionado com sucesso!")
            }
            .addOnFailureListener { e ->
                println("Erro ao remover o produtos {produto.toString()}: $e")
            }.await()
    }

}
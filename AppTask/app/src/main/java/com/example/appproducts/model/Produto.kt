package com.example.appproducts.model

import com.google.firebase.firestore.DocumentId

data class Produto(var nome: String, var preco: Double) {
    @DocumentId
    var id: String = ""
    constructor() : this("", 0.0)
}

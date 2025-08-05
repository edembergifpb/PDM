package com.example.buscacep.clientservice

import com.example.buscacep.model.Endereco
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EnderecoAPI {
    @GET("/ws/{cep}/json/")
    suspend fun getEnderecoByCEP(@Path("cep") cep: String): Endereco

}
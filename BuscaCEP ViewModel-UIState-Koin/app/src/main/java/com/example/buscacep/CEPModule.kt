package com.example.buscacep

import com.example.buscacep.clientservice.CepRepository
import com.example.buscacep.viewmodels.EnderecoViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module{
    singleOf(::CepRepository)
    viewModel {
        EnderecoViewModel(get())
    }
}
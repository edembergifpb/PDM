package com.example.mygoods.koin

import androidx.room.Room
import com.example.mygoods.data.AppDatabase
import com.example.mygoods.data.ProductRepository
import com.example.mygoods.viewmodels.ProductViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val databaseModule = module {
    single{
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
    single { get<AppDatabase>().productDao() }
    singleOf(::ProductRepository)
}

val appModule = module {
    viewModelOf(::ProductViewModel)
}
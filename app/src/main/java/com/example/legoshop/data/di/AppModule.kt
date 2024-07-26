package com.example.legoshop.data.di

import android.content.Context
import com.example.legoshop.data.local.ItemDatabase
import com.example.legoshop.data.repository.ItemRepositoryImpl
import com.example.legoshop.domain.repository.ItemRepository

/**
 * App Module for Manual Dependency Injection.
 */
interface AppModule {
    val itemRepository: ItemRepository
}

/**
 * [AppModule] implementation that provides instance of [ItemRepository]
 */
class AppModuleImpl(
    private val appContext: Context
): AppModule {
    override val itemRepository: ItemRepository by lazy {
        ItemRepositoryImpl(ItemDatabase.getDatabase(appContext).itemListingDao())
    }
}


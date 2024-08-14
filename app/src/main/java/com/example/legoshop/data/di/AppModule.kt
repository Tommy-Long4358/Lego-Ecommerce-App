package com.example.legoshop.data.di

import android.content.Context
import com.example.legoshop.data.local.ItemDatabase
import com.example.legoshop.data.repository.AuthRepositoryImpl
import com.example.legoshop.data.repository.ItemRepositoryImpl
import com.example.legoshop.domain.repository.AuthRepository
import com.example.legoshop.domain.repository.ItemRepository
import com.google.firebase.auth.FirebaseAuth

/**
 * App Module for Manual Dependency Injection.
 */
interface AppModule {
    val itemRepository: ItemRepository
    val authRepository: AuthRepository
}

/**
 * [AppModule] implementation that provides instance of [ItemRepository]
 */
class AppModuleImpl(
    private val appContext: Context
): AppModule {
    override val itemRepository: ItemRepository by lazy {
        ItemRepositoryImpl(itemListingDao = ItemDatabase.getDatabase(appContext).itemListingDao())
    }

    override val authRepository: AuthRepository by lazy {
        AuthRepositoryImpl(
            accountDao = ItemDatabase.getDatabase(appContext).accountDao(),
            firebaseAuth = FirebaseAuth.getInstance()
        )
    }
}


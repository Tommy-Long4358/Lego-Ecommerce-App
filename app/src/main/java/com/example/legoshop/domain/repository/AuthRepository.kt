package com.example.legoshop.domain.repository

import androidx.lifecycle.MutableLiveData
import com.example.legoshop.util.Resource
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    // We use a Flow type to get a very recent update of the app's authentication state
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun registerUser(username: String, email: String, password: String): Flow<Resource<AuthResult>>
    suspend fun addAccount(username: String, email: String)
}
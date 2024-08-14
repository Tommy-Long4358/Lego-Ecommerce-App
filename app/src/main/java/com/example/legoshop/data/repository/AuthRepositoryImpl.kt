package com.example.legoshop.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.legoshop.data.local.entities.account.AccountDao
import com.example.legoshop.data.mapper.toAccountEntity
import com.example.legoshop.domain.model.Account
import com.example.legoshop.domain.repository.AuthRepository
import com.example.legoshop.util.Resource
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl(
    private val accountDao: AccountDao,
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override fun loginUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            // Emit Loading state as user is being authenticated
            emit(value = Resource.Loading())

            // Handles authenticating and sign-in action in a separate thread
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()

            // After signing in user, emit Success state with result of authentication
            emit(value = Resource.Success(data = result))
        }.catch {
            // Error handling
            emit(value = Resource.Error(it.message.toString()))
        }
    }

    override fun registerUser(username: String, email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(value = Resource.Loading())

            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()

            emit(value = Resource.Success(data = result))
        }.catch {
            emit(value = Resource.Error(it.message.toString()))
        }
    }

    override suspend fun addAccount(username: String, email: String) {
        accountDao.addAccount(Account(username, email).toAccountEntity())
    }
}
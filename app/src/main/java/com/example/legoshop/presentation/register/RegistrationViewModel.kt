package com.example.legoshop.presentation.register

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.legoshop.data.mapper.toAccountEntity
import com.example.legoshop.domain.model.Account
import com.example.legoshop.domain.repository.AuthRepository
import com.example.legoshop.domain.repository.ItemRepository
import com.example.legoshop.util.Resource
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val repository: AuthRepository
): ViewModel() {
    private var _registrationState = MutableStateFlow(value = RegistrationState())
    val registrationState: StateFlow<RegistrationState> = _registrationState.asStateFlow()

    suspend fun registerUser(username: String, email: String, password: String) {
        repository.registerUser(username, email, password).collectLatest { result ->
            when(result) {
                is Resource.Success -> {
                    _registrationState.update { it.copy(
                        account = Account(email, password)
                    ) }
                }
                is Resource.Error -> Log.e("Error", "Password must be 6 characters longer or more!")
                is Resource.Loading -> {
                    _registrationState.update { it.copy(isLoading = result.isLoading) }
                }
            }
        }
    }

    suspend fun addAccount(username: String, email: String) {
        repository.addAccount(username, email)
    }
}
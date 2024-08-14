package com.example.legoshop.presentation.register

import com.example.legoshop.domain.model.Account

data class RegistrationState(
    val account: Account? = null,
    val isLoading: Boolean = false
)

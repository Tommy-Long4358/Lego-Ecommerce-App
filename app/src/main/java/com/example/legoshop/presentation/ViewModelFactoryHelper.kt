package com.example.legoshop.presentation

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.legoshop.ItemApplication
import com.example.legoshop.presentation.home.HomeViewModel
import com.example.legoshop.presentation.item.ItemCreateViewModel
import com.example.legoshop.presentation.register.RegistrationViewModel


object ViewModelFactoryHelper {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(itemApplication().appModule.itemRepository)
        }

        initializer {
            ItemCreateViewModel(itemApplication().appModule.itemRepository)
        }

        initializer {
            RegistrationViewModel(itemApplication().appModule.authRepository)
        }
    }
}


fun CreationExtras.itemApplication(): ItemApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ItemApplication)
package com.example.legoshop.presentation

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.legoshop.ItemApplication
import com.example.legoshop.presentation.home.HomeViewModel
import com.example.legoshop.presentation.item.ItemCreateViewModel


object ViewModelFactoryHelper {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(itemApplication().appModule.itemRepository)
        }

        initializer {
            ItemCreateViewModel(itemApplication().appModule.itemRepository)
        }
    }
}


fun CreationExtras.itemApplication(): ItemApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ItemApplication)
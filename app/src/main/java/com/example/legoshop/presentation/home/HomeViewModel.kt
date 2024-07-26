package com.example.legoshop.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.legoshop.domain.repository.ItemRepository
import kotlinx.coroutines.launch

class HomeViewModel (
    private val repository: ItemRepository
): ViewModel() {

    var state: HomeUiState by mutableStateOf(HomeUiState())

    fun getItemListings() {
        viewModelScope.launch {
            val listings = repository.getAllItemListings()

            state = state.copy(
                itemListings = listings
            )
        }
    }

    suspend fun getNumOfItemListings(): Int {
        return repository.getNumOfItemListings()
    }
}
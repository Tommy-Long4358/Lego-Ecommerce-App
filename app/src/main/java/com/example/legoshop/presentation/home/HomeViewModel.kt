package com.example.legoshop.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.legoshop.data.mapper.toItemListingDetails
import com.example.legoshop.domain.model.ItemListing
import com.example.legoshop.domain.repository.ItemRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

/**
 * viewModel to display items from database.
 */
class HomeViewModel (
    private val repository: ItemRepository
): ViewModel() {

    var homeUiState: HomeUiState by mutableStateOf(HomeUiState())

    init {
        getAllItemListings()
    }

    private fun getAllItemListings() {
        viewModelScope.launch {
            val listings = repository.getAllItemListings().first()

            homeUiState = homeUiState.copy(
                itemListings = listings
            )
        }
    }

    suspend fun getNumOfItemListings(): Int {
        return repository.getNumOfItemListings()
    }
}
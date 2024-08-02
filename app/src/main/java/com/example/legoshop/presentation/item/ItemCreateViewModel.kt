package com.example.legoshop.presentation.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.legoshop.data.mapper.toItemListing
import com.example.legoshop.domain.repository.ItemRepository

/**
 * viewModel to validate and insert items in Room database.
 */
class ItemCreateViewModel(private val itemRepository: ItemRepository) : ViewModel() {
    var itemUiState by mutableStateOf(ItemUiState())
        private set

    fun updateUiState(itemListingDetails: ItemListingDetails) {
        itemUiState = ItemUiState(
            itemListingDetails = itemListingDetails,
            isEntryValid = validateInput(itemListingDetails)
        )
    }

    suspend fun saveItem() {
        if (validateInput()) {
            itemRepository.insertItemListing(itemUiState.itemListingDetails.toItemListing())
        }
    }

    private fun validateInput(uiState: ItemListingDetails = itemUiState.itemListingDetails): Boolean {
        return with(uiState) {
            title.isNotBlank() && price.isNotBlank() && description.isNotBlank()
        }
    }
}
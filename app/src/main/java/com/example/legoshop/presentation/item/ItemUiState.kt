package com.example.legoshop.presentation.item

import com.example.legoshop.domain.model.ItemListing
import java.text.NumberFormat

data class ItemUiState(
    val itemListingDetails: ItemListingDetails = ItemListingDetails(),
    val isEntryValid: Boolean = false
)

data class ItemListingDetails(
    val title: String = "",
    val price: String = "",
    val description: String = ""
)
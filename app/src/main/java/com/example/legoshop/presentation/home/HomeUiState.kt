package com.example.legoshop.presentation.home

import com.example.legoshop.domain.model.ItemListing

data class HomeUiState(
    val itemListings: List<ItemListing> = emptyList()
)
package com.example.legoshop.domain.repository

import com.example.legoshop.data.local.ItemListingEntity
import com.example.legoshop.domain.model.ItemListing
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    suspend fun getAllItemListings(): List<ItemListing>

    suspend fun getNumOfItemListings(): Int
}
package com.example.legoshop.domain.repository

import com.example.legoshop.domain.model.ItemListing
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getAllItemListings(): Flow<List<ItemListing>>

    suspend fun getNumOfItemListings(): Int

    suspend fun insertItemListing(itemListing: ItemListing)
}
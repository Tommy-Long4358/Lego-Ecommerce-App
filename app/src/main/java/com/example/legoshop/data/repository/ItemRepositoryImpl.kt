package com.example.legoshop.data.repository

import com.example.legoshop.data.local.ItemListingDao
import com.example.legoshop.data.mapper.toItemListing
import com.example.legoshop.domain.model.ItemListing
import com.example.legoshop.domain.repository.ItemRepository

/**
 * Implementation of [ItemRepository]
 */
class ItemRepositoryImpl (
    private val itemListingDao: ItemListingDao
) : ItemRepository {
    override suspend fun getAllItemListings(): List<ItemListing> {
        return itemListingDao.getAllItemListings().map { it.toItemListing() }
    }

    override suspend fun getNumOfItemListings(): Int {
        return itemListingDao.getNumOfItemListings()
    }
}
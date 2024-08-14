package com.example.legoshop.data.repository

import com.example.legoshop.data.local.entities.itemlisting.ItemListingDao
import com.example.legoshop.data.mapper.toItemListing
import com.example.legoshop.data.mapper.toItemListingEntity
import com.example.legoshop.domain.model.ItemListing
import com.example.legoshop.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Implementation of [ItemRepository]
 */
class ItemRepositoryImpl (
    private val itemListingDao: ItemListingDao
) : ItemRepository {
    override fun getAllItemListings(): Flow<List<ItemListing>> {
       return itemListingDao.getAllItemListings().map { itemListings ->
            itemListings.map {
                it.toItemListing()
            }
        }
    }

    override suspend fun getNumOfItemListings(): Int {
        return itemListingDao.getNumOfItemListings()
    }

    override suspend fun insertItemListing(itemListing: ItemListing) {
        itemListingDao.insert(itemListing.toItemListingEntity())
    }
}
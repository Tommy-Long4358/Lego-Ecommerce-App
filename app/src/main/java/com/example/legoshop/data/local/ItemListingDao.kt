package com.example.legoshop.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemListingDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(itemListing: ItemListingEntity)

    @Update
    suspend fun update(itemListing: ItemListingEntity)

    @Delete
    suspend fun delete(itemListing: ItemListingEntity)

    @Query("SELECT * FROM listings")
    fun getAllItemListings(): Flow<List<ItemListingEntity>>

    @Query("SELECT COUNT(*) FROM listings")
    fun getNumOfItemListings(): Int
}
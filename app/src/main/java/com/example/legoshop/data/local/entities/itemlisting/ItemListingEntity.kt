package com.example.legoshop.data.local.entities.itemlisting

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "listings")
data class ItemListingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val price: Double,
    val description: String,
)
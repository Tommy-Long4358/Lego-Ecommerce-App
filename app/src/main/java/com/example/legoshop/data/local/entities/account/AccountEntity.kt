package com.example.legoshop.data.local.entities.account

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.legoshop.data.local.entities.itemlisting.ItemListingEntity

@Entity(tableName = "accounts")
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val username: String,
    val email: String,
)

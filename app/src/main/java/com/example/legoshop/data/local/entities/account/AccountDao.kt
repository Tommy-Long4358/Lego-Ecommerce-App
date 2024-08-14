package com.example.legoshop.data.local.entities.account

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.legoshop.domain.model.Account

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAccount(account: AccountEntity)
}
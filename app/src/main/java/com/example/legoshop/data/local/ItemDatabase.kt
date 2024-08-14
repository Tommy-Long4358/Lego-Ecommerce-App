package com.example.legoshop.data.local
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.legoshop.data.local.entities.account.AccountDao
import com.example.legoshop.data.local.entities.account.AccountEntity
import com.example.legoshop.data.local.entities.itemlisting.ItemListingDao
import com.example.legoshop.data.local.entities.itemlisting.ItemListingEntity

/**
 * Database class with a singleton Instance object
 */
@Database(
    entities = [ItemListingEntity::class, AccountEntity::class],
    version = 2,
    exportSchema = false
)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemListingDao(): ItemListingDao
    abstract fun accountDao(): AccountDao

    companion object {
        @Volatile
        private var Instance: ItemDatabase? = null

        fun getDatabase(context: Context): ItemDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ItemDatabase::class.java, "item_db")
                    /**
                     * Setting this option in your app's database builder means that Room
                     * permanently deletes all data from the tables in your database when it
                     * attempts to perform a migration with no defined migration path.
                     */
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
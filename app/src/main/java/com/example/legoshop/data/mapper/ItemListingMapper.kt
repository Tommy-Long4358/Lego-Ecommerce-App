package com.example.legoshop.data.mapper

import com.example.legoshop.data.local.ItemListingEntity
import com.example.legoshop.domain.model.ItemListing

/**
 * Converts [ItemListingEntity] to [ItemListing]
 */
fun ItemListingEntity.toItemListing(): ItemListing {
    return ItemListing(
        title = title,
        price = price,
        seller = seller,
        description = description
    )
}

/**
 * Converts [ItemListing] to [ItemListingEntity]
 */
fun ItemListing.toItemListingEntity(): ItemListingEntity {
    return ItemListingEntity(
        title = title,
        price = price,
        seller = seller,
        description = description
    )
}
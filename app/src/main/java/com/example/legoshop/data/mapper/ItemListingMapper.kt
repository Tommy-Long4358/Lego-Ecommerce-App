package com.example.legoshop.data.mapper

import com.example.legoshop.data.local.entities.itemlisting.ItemListingEntity
import com.example.legoshop.domain.model.ItemListing
import com.example.legoshop.presentation.item.ItemListingDetails
import com.example.legoshop.presentation.item.ItemUiState

/**
 * Converts [ItemListingEntity] to [ItemListing]
 */
fun ItemListingEntity.toItemListing(): ItemListing {
    return ItemListing(
        title = title,
        price = price,
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
        description = description
    )
}

/**
 * Converts [ItemListingDetails] to [ItemListing]
 */
fun ItemListingDetails.toItemListing(): ItemListing = ItemListing(
    title = title,
    price = price.toDoubleOrNull() ?: 0.0,
    description = description
)

/**
 * Converts [ItemListing] to [ItemListingDetails]
 */
fun ItemListing.toItemListingDetails(): ItemListingDetails = ItemListingDetails(
    title = title,
    price = price.toString(),
    description = description
)

/**
 * Converts [ItemListing] to [ItemUiState]
 */
fun ItemListing.toItemUiState(isEntryValid: Boolean = false): ItemUiState = ItemUiState(
    itemListingDetails = this.toItemListingDetails(),
    isEntryValid = isEntryValid
)
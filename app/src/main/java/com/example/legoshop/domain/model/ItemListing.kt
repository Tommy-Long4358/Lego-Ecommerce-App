package com.example.legoshop.domain.model

/**
 * Acts as a communication between data and UI layer to have clear separation of layers.
 * Ensures that presentation layer does not access data layer.
 */
data class ItemListing(
    val title: String,
    val price: Double,
    val seller: String,
    val description: String,
)

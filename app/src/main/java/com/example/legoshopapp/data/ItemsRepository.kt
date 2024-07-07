package com.example.legoshopapp.data

import com.example.legoshopapp.R

object ItemsRepository {
    val items = listOf(
        Item(
            imgSrc = R.drawable.listing_1,
            name = "Kessel Run Millenium Falcon",
            price = "$189.99"
        ),
        Item(
            imgSrc = R.drawable.listing_2,
            name = "Bounty Hunter Pursuit",
            price = "$179.99"
        ),
        Item(
            imgSrc = R.drawable.listing_3,
            name = "UCS Naboo Starfighter Chrome",
            price = "$139.99"
        ),
        Item(
            imgSrc = R.drawable.listing_4,
            name = "Republic Cruiser",
            price = "$299.99"
        )
    )
}
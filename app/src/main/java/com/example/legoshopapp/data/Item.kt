package com.example.legoshopapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Item(
    @DrawableRes val imgSrc: Int,
    val name: String,
    val price: String
)
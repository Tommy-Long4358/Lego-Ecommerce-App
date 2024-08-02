package com.example.legoshop.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LegoProduct(
    @SerialName(value = "set_num")
    val setNum: String,
    val name: String,
    val year: String,
    @SerialName(value = "num_parts")
    val numParts: Int,
    @SerialName(value = "set_img_url")
    val setImgUrl: String,
)
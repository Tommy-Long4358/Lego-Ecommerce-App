package com.example.legoshop.data.remote

import com.example.legoshop.data.remote.dto.LegoProduct
import retrofit2.http.GET

interface LegoApi {
    @GET("lego/sets")
    suspend fun getSetDetails(): LegoProduct

    @GET("lego/sets/{set_num}")
    suspend fun getSetMinifigs(): LegoProduct

    companion object {
        const val API_KEY = "c102c785e3958ca318d6c5ccb5b1b9da"
        const val BASE_URL = "https://rebrickable.com/api/v3/"
    }
}
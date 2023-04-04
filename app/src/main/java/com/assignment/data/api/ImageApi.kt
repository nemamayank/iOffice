package com.assignment.data.api

import com.assignment.data.models.Data
import com.assignment.data.models.SearchImage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {
    @GET("gallery/search/")
    suspend fun getSearchImages(
        @Query("q") q: String,
        @Query("sort") sort: String,
        @Query("window") window: String
    ): SearchImage
}
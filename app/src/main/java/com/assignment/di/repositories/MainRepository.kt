package com.assignment.di.repositories

import com.assignment.data.api.ImageApiHelper

class MainRepository (private val apiHelper: ImageApiHelper) {

    suspend fun getSearchImages(searchText: String, sort: String, window: String) = apiHelper.getSearchImages(searchText, sort = "top", window = "all")
}
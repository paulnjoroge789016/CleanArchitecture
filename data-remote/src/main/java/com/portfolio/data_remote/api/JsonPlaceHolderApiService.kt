package com.portfolio.data_remote.api

import com.portfolio.data_remote.models.Post
import com.portfolio.data_remote.models.PostResponse

import retrofit2.http.GET

/**
 * A good programmer writes code that can be understood
 * by humans
 */
interface JsonPlaceHolderApiService {

    @GET("/posts")
    suspend fun getPosts(): PostResponse
}
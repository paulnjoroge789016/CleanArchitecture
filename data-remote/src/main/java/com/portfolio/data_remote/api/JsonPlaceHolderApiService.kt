package com.portfolio.data_remote.api

import com.portfolio.data_remote.models.Post
import com.portfolio.data_remote.models.PostResponse

import retrofit2.http.GET
import retrofit2.http.Headers


interface JsonPlaceHolderApiService {

    @Headers(
        "content-type: Application/json"
    )
    @GET("/posts")
    suspend fun getPosts(): ArrayList<Post>
}
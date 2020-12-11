package com.portfolio.domain.data

interface PostDataSource {

    fun getPost()
    fun updatePost(id: Int)
    fun putPost(id: Int)
    fun deletePost(id: Int)
}
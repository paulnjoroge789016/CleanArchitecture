package com.portfolio.domain.repository

import com.portfolio.domain.data.entities.Post
import kotlinx.coroutines.flow.Flow


/**
 * A good programmer  code that can be understood
 * by humans
 */
interface IPostRepository {

    suspend fun getAll(): Flow<List<Post>>

    suspend fun post(): Flow<Post>

    suspend fun update(id: Int): Flow<Post>

    suspend fun delete(id: Int): Flow<Post>
}
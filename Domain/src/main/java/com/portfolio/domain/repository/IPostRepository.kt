package com.portfolio.domain.repository

import com.portfolio.domain.data.entities.Post
import com.portfolio.domain.data.entities.Result
import kotlinx.coroutines.flow.Flow


/**
 * A good programmer  code that can be understood
 * by humans
 */
interface IPostRepository {

    suspend fun getAll(): Flow<Result<ArrayList<Post>>>


}
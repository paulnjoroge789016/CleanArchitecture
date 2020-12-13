package com.portfolio.data_remote.repository

import com.portfolio.domain.data.entities.Post
import com.portfolio.domain.repository.IPostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * A good programmer writes code that can be understood
 * by humans
 */
class PostRepository @Inject constructor() : IPostRepository {
    override suspend fun getAll(): Flow<List<Post>>  = flow {
        TODO("Not yet implemented")
    }

    override suspend fun post(): Flow<Post> = flow{
        TODO("Not yet implemented")
    }

    override suspend fun update(id: Int): Flow<Post>  = flow{
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int): Flow<Post> = flow{
        TODO("Not yet implemented")
    }

}
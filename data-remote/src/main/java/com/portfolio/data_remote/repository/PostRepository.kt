package com.portfolio.data_remote.repository

import com.portfolio.data_remote.api.JsonPlaceHolderApiService
import com.portfolio.data_remote.mappers.toDomain
import com.portfolio.domain.data.entities.Result
import com.portfolio.domain.data.entities.Post
import com.portfolio.domain.repository.IPostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * A good programmer writes code that can be understood
 * by humans
 */
class PostRepository @Inject constructor(
    private val jsonPlaceHolderApiService: JsonPlaceHolderApiService
) : IPostRepository {
    override suspend fun getAll(): Flow<Result<ArrayList<Post>>> = flow {
        emit(Result.Loading)
        try {
            val posts = ArrayList<Post>()

            val postResponse = jsonPlaceHolderApiService.getPosts()
            postResponse.forEach {
                posts.add(it.toDomain())
            }
            emit(Result.Success(posts))
        } catch (throwable: Throwable){
            throwable.printStackTrace()
            emit(Result.Failed(throwable))
        }
    }


}
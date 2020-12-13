package com.portfolio.domain.usecases

import com.portfolio.domain.repository.IPostRepository
import javax.inject.Inject

/**
 * A good programmer writes code that can be understood
 * by humans
 */
class GetAllPostsUseCase @Inject constructor(private val postRepository: IPostRepository) {
    suspend fun getAllPosts() = postRepository.getAll()
}
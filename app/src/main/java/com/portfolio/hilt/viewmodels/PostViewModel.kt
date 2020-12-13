package com.portfolio.hilt.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.portfolio.domain.data.entities.Post
import com.portfolio.domain.usecases.GetAllPostsUseCase

/**
 * A good programmer writes code that can be understood
 * by humans
 */
class PostViewModel @ViewModelInject constructor(
    private val postsUseCase: GetAllPostsUseCase,
    @Assisted private val savedStateHandle: SavedStateHandle
) {

    private val posts: MutableLiveData<Result<ArrayList<Post>>> = MutableLiveData()
    val _post get() = posts
}
package com.portfolio.hilt.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.portfolio.domain.usecases.GetAllPostsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * A good programmer writes code that can be understood
 * by humans
 */
class PostViewModel @ViewModelInject constructor(
    private val postsUseCase: GetAllPostsUseCase,
    @Assisted private val savedStateHandle: SavedStateHandle
) {

    private val _posts: MutableLiveData<Result<ArrayList<com.portfolio.data_remote.models.Post>>> = MutableLiveData()
    val post: LiveData<Result<ArrayList<com.portfolio.data_remote.models.Post>>> get() = _posts

    fun getAllPosts() {

        CoroutineScope(Dispatchers.IO).launch {

            val posts  = postsUseCase.getAllPosts().collect{
                _posts.value
            }


        }


    }
}
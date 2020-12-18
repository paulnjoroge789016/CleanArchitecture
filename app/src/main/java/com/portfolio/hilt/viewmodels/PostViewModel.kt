package com.portfolio.hilt.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.portfolio.domain.data.entities.Post
import com.portfolio.domain.data.entities.Result
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
) : ViewModel(){

    private val _posts: MutableLiveData<com.portfolio.domain.data.entities.Result<ArrayList<Post>>> = MutableLiveData()
    val post: LiveData<Result<ArrayList<Post>>> get() = _posts

    fun getAllPosts() {

        CoroutineScope(Dispatchers.IO).launch {


            postsUseCase.getAllPosts().collect {
                _posts.postValue(it)
            }


        }




    }
}
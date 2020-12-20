package com.portfolio.hilt.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.portfolio.domain.data.entities.Result
import com.portfolio.domain.usecases.GetAllPostsUseCase
import com.portfolio.hilt.mappers.toPresentation
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

    private val _posts: MutableLiveData<ArrayList<com.portfolio.hilt.models.Post>> = MutableLiveData()
    val posts: LiveData<ArrayList<com.portfolio.hilt.models.Post>> get() = _posts

    private val _loadingState: MutableLiveData<Boolean> = MutableLiveData()
    val loadingState: LiveData<Boolean> get() = _loadingState

    private val _errorMessage : MutableLiveData<String> = MutableLiveData()
    val errorMessage : MutableLiveData<String> = MutableLiveData()

    init {
        _loadingState.value = true
        _errorMessage.value = ""
    }
    fun getAllPosts() {

        viewModelScope.launch {
            val posts = ArrayList<com.portfolio.hilt.models.Post>()
            postsUseCase.getAllPosts().collect {results ->
                when(results){
                    is Result.Success ->{
                        results.data.forEach {
                            posts.add(
                                it.toPresentation()
                            )

                        }
                        _posts.postValue(posts)

//                        val pagedlist = LivePagedListBuilder<>
                        _loadingState.value = false
                    }

                    is Result.Loading -> {
                        _loadingState.value = true
                    }

                    is Result.Failed -> {
                        _loadingState.value = false
                        _errorMessage.value = results.throwable.message
                    }
                }
            }
        }
    }
}
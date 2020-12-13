package com.portfolio.data_remote.models

import com.portfolio.data_remote.R

/**
 * A good programmer writes code that can be understood
 * by humans
 */
sealed class Result <out R>{
    data class Success<out T>(val data: T): Result<T>()
    data class Failed<out T>(val throwable: T): Result<T>()
    object Loading: Result<Nothing>()
}
package com.portfolio.domain.data.entities



/**
 * A good programmer writes code that can be understood
 * by humans
 */
sealed class Result <out R>{
    data class Success<out T>(val data: T): Result<T>()
    data class Failed(val throwable: Throwable): Result<Nothing>()
    object Loading: Result<Nothing>()
}
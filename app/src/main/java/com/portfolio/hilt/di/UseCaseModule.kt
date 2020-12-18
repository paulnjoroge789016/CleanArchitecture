package com.portfolio.hilt.di

import com.portfolio.data_remote.repository.PostRepository
import com.portfolio.domain.usecases.GetAllPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * A good programmer writes code that can be understood
 * by humans
 */
@Module
@InstallIn(ApplicationComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetAllPostsUseCase(postRepository: PostRepository): GetAllPostsUseCase{
        return GetAllPostsUseCase(postRepository)
    }
}
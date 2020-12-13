package com.portfolio.hilt.di

import com.portfolio.data_remote.api.JsonPlaceHolderApiService
import com.portfolio.data_remote.repository.PostRepository
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
object RepositoryModule {


    @Provides
    @Singleton
    fun providePostRepository(retrofit: JsonPlaceHolderApiService): PostRepository {
        return PostRepository(retrofit)
    }
}
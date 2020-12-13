package com.portfolio.domain.di

import com.portfolio.domain.data.PostDataSource
import com.portfolio.domain.data.PostDataSourceImpl
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
class DomainModule{


    @Provides
    @Singleton
    fun provideDataSourceDependency(): PostDataSource{
        return PostDataSourceImpl()
    }
}
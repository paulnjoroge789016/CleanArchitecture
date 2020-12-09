package com.portfolio.hilt

import com.portfolio.domain.DataSource
import com.portfolio.domain.DataSourceImpl
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
 class MyModule {

   @Provides
   @Singleton
   fun provideSomeInterface(
   ): SomeInterface {
       return SomeInterfaceImpl()
   }


    @Provides
    @Singleton
    fun provideDomainDependency(): DataSource{
        return DataSourceImpl()
    }

}
package com.portfolio.data_remote.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.portfolio.data_remote.api.JsonPlaceHolderApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * A good programmer writes code that can be understood
 * by humans
 */

@Module
@InstallIn(ApplicationComponent::class)
class RetrofitModule {


    @Provides
    @Singleton
    fun provideGsonBuilder(): Gson{
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }


    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))

    }

    @Provides
    @Singleton
    fun provideJsonPlaceHolderDependency(retrofit: Retrofit.Builder): JsonPlaceHolderApiService{
        return retrofit
            .build()
            .create(JsonPlaceHolderApiService::class.java)
    }

}
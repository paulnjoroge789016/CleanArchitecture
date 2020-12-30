package com.portfolio.hilt.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.portfolio.data_remote.api.JsonPlaceHolderApiService
import com.portfolio.hilt.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {


    @Provides
    @Singleton
    fun provideGsonBuilder(): Gson{
        return GsonBuilder()
            .create()
    }


    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, httpClient: OkHttpClient): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))

    }

    @Provides
    @Singleton
    fun provideJsonPlaceHolderDependency(retrofit: Retrofit.Builder): JsonPlaceHolderApiService{
        return retrofit
            .build()
            .create(JsonPlaceHolderApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
        return if(BuildConfig.DEBUG){
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        } else {
            OkHttpClient.Builder()
                .build()
        }
    }

}
package com.agesadev.shipswezacare.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    val BASE_URL = "https://api.spacexdata.com/v3/"


    @Singleton
    @Provides
    fun getRetrofitServiceInstance(retrofit: Retrofit): RetrofitServiceInterface {
        return retrofit.create(RetrofitServiceInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
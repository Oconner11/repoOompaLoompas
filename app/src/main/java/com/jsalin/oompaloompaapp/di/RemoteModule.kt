package com.jsalin.oompaloompaapp.di

import com.jsalin.oompaloompaapp.data.remote.OompaLoompaApi
import com.jsalin.oompaloompaapp.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideOompaLoompasApi(): OompaLoompaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OompaLoompaApi::class.java)
    }
}
package com.example.dapapp.data

import com.example.dapapp.BuildConfig.BASE_URL
import com.example.dapapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    @Provides
    fun provideApodApiService(retrofit: Retrofit): ApodApiService{
        return retrofit.create(ApodApiService::class.java)
    }
    @Provides
    fun provideRepository(apiService: ApodApiService): Repository {
        return RepositoryImpl(apiService)

    }
}
package com.example.dapapp.data

import com.example.dapapp.domain.model.AstronomicItemResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApodApiService {

    @GET("&date")
    suspend fun getApod(@Path("date") date: String): AstronomicItemResponse
}
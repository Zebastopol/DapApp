package com.example.dapapp.data

import android.util.Log
import com.example.dapapp.domain.Repository
import com.example.dapapp.domain.model.AstronomicItemModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApodApiService) : Repository {

    override suspend fun getApod(date: String): AstronomicItemModel? {
        runCatching { apiService.getApod(date) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("ZP0L", "There has been an error ${it.message}") }
        return null
    }
}
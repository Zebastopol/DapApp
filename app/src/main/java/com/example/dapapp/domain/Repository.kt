package com.example.dapapp.domain

import com.example.dapapp.domain.model.AstronomicItemModel

interface Repository {
    suspend fun getApod(date: String): AstronomicItemModel?
}
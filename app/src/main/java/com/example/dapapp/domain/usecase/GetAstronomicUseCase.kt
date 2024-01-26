package com.example.dapapp.domain.usecase

import com.example.dapapp.domain.Repository
import javax.inject.Inject

class GetAstronomicUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(date: String) = repository.getApod(date)
}
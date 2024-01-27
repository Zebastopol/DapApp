package com.example.dapapp.ui.today

import com.example.dapapp.domain.model.AstronomicItemModel

sealed class AstronomicTodayState {

    data object Loading : AstronomicTodayState()
    data class Error(val error: String) : AstronomicTodayState()
    data class Success(
        val date: String,
        val explanation: String,
        val hdurl: String,
        val title: String,
        val url: String,
        val copyright: String, val item: AstronomicItemModel
    ) : AstronomicTodayState()
}
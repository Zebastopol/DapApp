package com.example.dapapp.domain.model

sealed class AstroModel(
    var date: String,
    var explanation: String,
    var hdurl: String,
    var media_type: String,
    var title: String,
    var url: String)
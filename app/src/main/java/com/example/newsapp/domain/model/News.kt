package com.example.newsapp.domain.model

data class News(
    val title: String,
    val description: String?,
    val url: String,
    val image: String?,
    val publishedAt: String
)
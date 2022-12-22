package com.example.newsapp.data.entities

data class NewsResponseDTO(
    val articles: List<ArticleDTO>,
    val status: String,
    val totalResults: Int
)
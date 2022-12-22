package com.example.newsapp.data.entities

data class ArticleDTO(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val sourceDTO: SourceDTO,
    val title: String,
    val url: String,
    val urlToImage: String
)
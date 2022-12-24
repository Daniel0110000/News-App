package com.example.newsapp.data.mappers

import com.example.newsapp.data.entities.NewsResponseDTO
import com.example.newsapp.domain.model.News

fun NewsResponseDTO.getMapper(): ArrayList<News>{
    val array: ArrayList<News> = arrayListOf()
    this.articles.forEach {
        array.addAll(
            listOf(
                News(
                    title = it.title,
                    description = it.description,
                    url = it.url,
                    image = it.urlToImage,
                    publishedAt = it.publishedAt
                )
            )
        )
    }
    return array
}
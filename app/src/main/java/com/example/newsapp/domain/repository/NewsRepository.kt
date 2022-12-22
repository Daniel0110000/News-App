package com.example.newsapp.domain.repository

import com.example.newsapp.domain.model.News
import com.example.newsapp.domain.utilities.Resource

interface NewsRepository {

    suspend fun getGeneralNews(): Resource<ArrayList<News>>

    suspend fun getNewsByCategory(category: String): Resource<ArrayList<News>>

}
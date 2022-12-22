package com.example.newsapp.domain.domain

import com.example.newsapp.domain.model.News
import com.example.newsapp.domain.utilities.Resource

interface NewsRepository {

    suspend fun getGeneralNews(): Resource<ArrayList<News>>

}
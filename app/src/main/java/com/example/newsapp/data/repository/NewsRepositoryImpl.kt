package com.example.newsapp.data.repository

import com.example.newsapp.data.api.ApiService
import com.example.newsapp.data.mappers.getMapper
import com.example.newsapp.domain.domain.NewsRepository
import com.example.newsapp.domain.model.News
import com.example.newsapp.domain.utilities.Resource
import javax.inject.Inject

class NewsRepositoryImpl
    @Inject
    constructor(
        private val apiService: ApiService
    ): NewsRepository {

    override suspend fun getGeneralNews(): Resource<ArrayList<News>> {
        return try {
            Resource.Success(
                data = apiService.getGeneralNews().getMapper()
            )
        }catch (e:Exception){
            Resource.Error(
                message = "Error ${e.message}!"
            )
        }
    }
}
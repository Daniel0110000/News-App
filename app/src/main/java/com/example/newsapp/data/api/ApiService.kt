package com.example.newsapp.data.api

import com.example.newsapp.data.entities.NewsResponseDTO
import com.example.newsapp.domain.utilities.Constants.API_KEY
import com.example.newsapp.domain.utilities.Constants.PATH_URL
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(PATH_URL)
    suspend fun getGeneralNews(
        @Query("category") category: String = "general",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponseDTO

    @GET(PATH_URL)
    suspend fun getNewsByCategory(
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponseDTO

    @GET(PATH_URL)
    suspend fun searchNews(
        @Query("q") q: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponseDTO


}
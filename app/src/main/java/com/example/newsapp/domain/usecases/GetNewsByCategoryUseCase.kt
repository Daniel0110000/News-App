package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsByCategoryUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(category: String) = newsRepository.getNewsByCategory(category)
}
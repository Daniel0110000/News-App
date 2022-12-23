package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

class SearchNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(q: String) = newsRepository.searchNews(q)
}
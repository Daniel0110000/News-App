package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.domain.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    suspend operator fun invoke() = newsRepository.getGeneralNews()
}
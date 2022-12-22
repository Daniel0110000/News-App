package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

class GetGeneralNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    suspend operator fun invoke() = newsRepository.getGeneralNews()
}
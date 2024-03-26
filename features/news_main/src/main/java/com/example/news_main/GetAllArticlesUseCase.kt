package com.example.news_main

import com.example.news_data.ArticlesRepository
import com.example.news_data.RequestResult
import com.example.news_data.model.Article
import kotlinx.coroutines.flow.Flow

class GetAllArticlesUseCase(private val repository:ArticlesRepository) {

    operator fun invoke(): RequestResult<Flow<List<Article>>> {
        return repository.getAll()
    }
}
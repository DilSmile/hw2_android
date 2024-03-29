package com.example.news_main

import com.example.news_data.ArticlesRepository
import com.example.news_data.RequestResult
import com.example.news_data.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.example.news_data.model.Article as DataArticle

class GetAllArticlesUseCase(private val repository: ArticlesRepository) {
    operator fun invoke(): Flow<RequestResult<List<Article>>> {
       return repository.getAll()
            .map{ requestResult ->
                requestResult.map { articles -> articles.map { it.toUiArticles() } }
            }
    }
}

private fun DataArticle.toUiArticles() : Article {
    TODO("Not yet implemented")
}
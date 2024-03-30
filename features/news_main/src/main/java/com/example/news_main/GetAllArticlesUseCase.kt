package com.example.news_main

import com.example.news_data.ArticlesRepository
import com.example.news_data.RequestResult
import com.example.news_data.map
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.example.news_data.model.Article as DataArticle

internal class GetAllArticlesUseCase @Inject constructor(
    private val repository: ArticlesRepository)
{
    operator fun invoke(): Flow<RequestResult<List<ArticleUI>>> {
       return repository.getAll()
            .map{ requestResult ->
                requestResult.map { articles -> articles.map { it.toUiArticles() } }
            }
    }
}

private fun DataArticle.toUiArticles() : ArticleUI {
    TODO("Not yet implemented")
}
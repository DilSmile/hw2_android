package com.example.news_main

import com.example.news_data.ArticleRepository
import com.example.news_data.RequestResult
import com.example.news_data.map
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.example.news_data.model.Article as DataArticle

internal class GetAllArticlesUseCase
@Inject
constructor(
    private val repository: ArticleRepository
) {
    operator fun invoke(query: String): Flow<RequestResult<List<ArticleUI>>> {
        return repository.getAll(query)
            .map { requestResult ->
                requestResult.map { articles -> articles.map { it.toUiArticle() } }
            }
    }
}

private fun DataArticle.toUiArticle(): ArticleUI {
    return ArticleUI(
        id = cacheId,
        title = title,
        description = description,
        imageUrl = urlToImage,
        url = url
    )
}

package com.example.news_data

import com.example.news_data.model.Article
import com.example.news_data.model.Source
import com.example.newsapi.models.ArticleDBO
import com.example.newsapi.models.ArticleDTO
import com.example.newsapi.models.Source as SourceDBO

internal fun ArticleDBO.toArticle(): Article {
    return Article(
        cacheId = id,
        source = Source(id = source.id, name = source.name),
        author = author,
        title = title,
        description = description,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt,
        content = content
    )
}

internal fun ArticleDTO.toArticle(): Article {
    return Article(
        source = Source(id = source.id, name = source.name),
        author = author ?: "",
        title = title,
        description = description,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt,
        content = content
    )
}

internal fun ArticleDTO.toArticleDbo(): ArticleDBO {
    return ArticleDBO(
        source = SourceDBO(id = source.id, name = source.name),
        author = author ?: "",
        title = title,
        description = description,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt,
        content = content,
        id = 0
    )
}

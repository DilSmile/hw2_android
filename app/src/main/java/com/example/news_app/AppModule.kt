package com.example.news_app

import android.content.Context
import com.example.common.AppDispatchers
import com.example.database.NewsDatabase
import com.example.news_data.ArticlesRepository
import com.example.newsapi.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsApi():NewsApi{
        return NewsApi(
            baseUrl = BuildConfig.NEWS_API_BASE_URL,
            apiKey = BuildConfig.NEWS_API_KEY,
        )
    }
    @Provides
    @Singleton
    fun provideNewsdatabase(@ApplicationContext context: Context):NewsDatabase{
        return NewsDatabase(context)
    }
    @Provides
    @Singleton
    fun provideAppCoroutineDisapatchers():AppDispatchers = AppDispatchers()
}
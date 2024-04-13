package com.example.news_app

import android.content.Context
import com.example.common.AndroidLogcatLogger
import com.example.common.AppDispatchers
import com.example.common.Logger
import com.example.database.NewsDatabase
import com.example.newsapi.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNewsApi(okHttpClient: OkHttpClient?): NewsApi {
        return NewsApi(
            baseUrl = BuildConfig.NEWS_API_BASE_URL,
            apiKey = BuildConfig.NEWS_API_KEY,
            okHttpClient = okHttpClient
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        @ApplicationContext context: Context
    ): NewsDatabase {
        return NewsDatabase(context)
    }

    @Provides
    @Singleton
    fun provideAppCoroutineDisapatchers(): AppDispatchers = AppDispatchers()

    @Provides
    @Singleton
    fun provideLogger(): Logger = AndroidLogcatLogger()
}

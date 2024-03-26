package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.database.dao.ArticleDao
import com.example.database.utils.Converters
import com.example.newsapi.models.ArticleDBO

class NewsDatabase internal constructor(private val database:NewsRoomDatabase){

    val articlesDao: ArticleDao
        get() = database.articlesDao()
}

@Database(entities = [ArticleDBO::class], version = 1)
@TypeConverters(Converters::class)
abstract class NewsRoomDatabase :RoomDatabase() {

    abstract fun articlesDao(): ArticleDao

}
fun NewsRoomDatabase(applicationContext:Context):NewsDatabase{
    val newsRoomDatabase = Room.databaseBuilder(
        checkNotNull(applicationContext.applicationContext) ,
        NewsRoomDatabase::class.java, "news"
    ).build()
    return NewsDatabase(newsRoomDatabase)
}
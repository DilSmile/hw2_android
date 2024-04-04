package com.example.news_data.model

import java.util.Date

data class Article  (
    val casheId:Long=ID_NONE,
    val source:Source,
    val author:String,
    val title:String,
    val description:String,
    val url:String,
    val urlToImage:String,
    val publishedAt: Date,
    val content:String

){
    companion object{
        const val ID_NONE = 0L
    }
}
data class Source (
    val id:String,
    val name:String
)
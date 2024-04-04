package com.example.common

import android.util.Log

interface Logger {
    fun d(tag:String,message:String)

    fun e(tag:String,message:String)
}
fun AndroidLogcarLogger():Logger = object :Logger{
    override fun d(tag: String, message: String) {
        Log.d(tag,message)
    }

    override fun e(tag: String, message: String) {
        Log.d(tag,message)
    }

}
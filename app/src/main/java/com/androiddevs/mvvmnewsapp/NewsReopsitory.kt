package com.androiddevs.mvvmnewsapp

import androidx.room.Database
import androidx.room.Query
import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ADatabase

class NewsReopsitory(val db: ADatabase) {

    suspend fun getbreakinnews(countrycode:String,page:Int) = RetrofitInstance.api.getBreakingNews(countrycode,page)

suspend fun getsearchnews(query: String,page: Int) = RetrofitInstance.api.geteverything(query,page)
}
package com.androiddevs.mvvmnewsapp.api

import com.androiddevs.mvvmnewsapp.entity.NewsResponse
import com.androiddevs.mvvmnewsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("/v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countrycode:String = "us",
        @Query("page")
        page:Int = 1,
        @Query("apikey")
        apiKey:String = API_KEY
    ):Response<NewsResponse>



    @GET("/v2/everything")
    suspend fun geteverything(
        @Query("q")
        searchQuery:String,
        @Query("page")
        page:Int = 1,
        @Query("apikey")
        apiKey:String = API_KEY
    ):Response<NewsResponse>
}
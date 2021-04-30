package com.androiddevs.mvvmnewsapp.entity

import com.androiddevs.mvvmnewsapp.entity.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
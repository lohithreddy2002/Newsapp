package com.androiddevs.mvvmnewsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewsViewFactory(val repo:NewsReopsitory):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewmodel(repo) as T
    }
}
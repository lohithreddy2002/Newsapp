package com.androiddevs.mvvmnewsapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.androiddevs.mvvmnewsapp.NewsViewmodel
import com.androiddevs.mvvmnewsapp.R

class SavedNewsFragmnet:Fragment(R.layout.fragment_saved_news) {
    lateinit var viewmodel: NewsViewmodel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = (activity as MainActivity).viewmodel

    }
}
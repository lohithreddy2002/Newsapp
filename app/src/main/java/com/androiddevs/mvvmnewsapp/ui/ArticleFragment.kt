package com.androiddevs.mvvmnewsapp.ui

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.androiddevs.mvvmnewsapp.NewsViewmodel
import com.androiddevs.mvvmnewsapp.R
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment:Fragment(R.layout.fragment_article) {
    lateinit var viewmodel: NewsViewmodel

    private val args:ArticleFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = (activity as MainActivity).viewmodel

        val aricle = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(aricle.url)
        }
    }
    
}
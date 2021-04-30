package com.androiddevs.mvvmnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Database
import com.androiddevs.mvvmnewsapp.NewsReopsitory
import com.androiddevs.mvvmnewsapp.NewsViewFactory
import com.androiddevs.mvvmnewsapp.NewsViewmodel
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.db.ADatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
lateinit var viewmodel: NewsViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val repository = NewsReopsitory(ADatabase(this))
        val factory = NewsViewFactory(repository)

        viewmodel = ViewModelProvider(this,factory).get(NewsViewmodel::class.java)
        bottomNavigationView.setupWithNavController(newsNavhost.findNavController())
    }
}

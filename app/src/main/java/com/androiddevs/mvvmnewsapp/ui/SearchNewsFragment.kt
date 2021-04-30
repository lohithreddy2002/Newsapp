package com.androiddevs.mvvmnewsapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevs.mvvmnewsapp.NewsAdapter
import com.androiddevs.mvvmnewsapp.NewsViewmodel
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.util.Resources
import kotlinx.android.synthetic.main.fragment_search_news.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchNewsFragment:Fragment(R.layout.fragment_search_news) {
    lateinit var viewmodel: NewsViewmodel
    lateinit var nadapter:NewsAdapter

    val TAG = "search news"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = (activity as MainActivity).viewmodel

setrecycle()

        var job:Job? = null
        etSearch.addTextChangedListener {
            job?.cancel()
            job = MainScope().launch {
                delay(500L)
                it?.let {
                    if(it.toString().isNotEmpty()){
                        viewmodel.getsearchnews(it.toString())
                    }
                }
            }
        }

    viewmodel.searchNews.observe(viewLifecycleOwner, Observer {response->
        when(response){
            is Resources.Success -> {
                hide()
                response.data?.let {news->
                    nadapter.differ.submitList(news.articles)
                }
            }
            is Resources.Failure ->{
                hide()
                response.message.let {
                    Log.e(TAG,"error occured")
                }
            }
            is Resources.Loading -> {
                show()
            }
        }

    })
}


private fun hide(){
    paginationProgressBar.visibility = View.INVISIBLE

}
private fun show(){
    paginationProgressBar.visibility =View.VISIBLE
}
private fun setrecycle() {
    nadapter = NewsAdapter()
    rvSearchNews.apply {
        adapter = nadapter
        layoutManager = LinearLayoutManager(activity)
    }
}
}
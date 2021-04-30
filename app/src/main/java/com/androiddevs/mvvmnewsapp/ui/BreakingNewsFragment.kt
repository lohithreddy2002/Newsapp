package com.androiddevs.mvvmnewsapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevs.mvvmnewsapp.NewsAdapter
import com.androiddevs.mvvmnewsapp.NewsViewmodel
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.util.Resources
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class BreakingNewsFragment:Fragment(R.layout.fragment_breaking_news) {
    lateinit var viewmodel: NewsViewmodel
    lateinit var nadapter: NewsAdapter

    val TAG = "breaking news"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel = (activity as MainActivity).viewmodel

        setrecycle()

        nadapter.setOnItemClickListner {
            val bundle = Bundle().apply {
                putSerializable("article",it)

            }
            findNavController().navigate(R.id.action_breakingNewsFragment_to_articleFragment,bundle)
        }
        viewmodel.breakingNews.observe(viewLifecycleOwner, Observer {response->
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
        rvBreakingNews.apply {
            adapter = nadapter
           layoutManager = LinearLayoutManager(activity)
        }
    }
}
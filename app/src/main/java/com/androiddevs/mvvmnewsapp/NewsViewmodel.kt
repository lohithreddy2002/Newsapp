package com.androiddevs.mvvmnewsapp


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.mvvmnewsapp.entity.NewsResponse
import com.androiddevs.mvvmnewsapp.util.Resources
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewmodel(val newsRepo:NewsReopsitory):ViewModel() {
val breakingNews : MutableLiveData<Resources<NewsResponse>> = MutableLiveData()
    var page_break = 1


    init{
        getBreakingnews("in")
    }


    fun getBreakingnews(countrycode:String) = viewModelScope.launch {
        breakingNews.postValue(Resources.Loading())
        val response = newsRepo.getbreakinnews(countrycode,page_break)
        breakingNews.postValue(handlebreakingreponse(response))


    }
    val searchNews : MutableLiveData<Resources<NewsResponse>> = MutableLiveData()
    val page_search = 1

    fun getsearchnews(q:String)= viewModelScope.launch {
searchNews.postValue(Resources.Loading())
        val response = newsRepo.getsearchnews(q,page_search)
        searchNews.postValue(handlesearchreponse(response))
    }


    private fun handlesearchreponse(responce:Response<NewsResponse>):Resources<NewsResponse>{
        if(responce.isSuccessful){
            responce.body()?.let {
                return Resources.Success(it)

            }
        }
        return Resources.Failure(responce.message())
    }


    private fun handlebreakingreponse(responce:Response<NewsResponse>):Resources<NewsResponse>{
        if(responce.isSuccessful){
            responce.body()?.let {
                return Resources.Success(it)

            }
        }
        return Resources.Failure(responce.message())
    }



}
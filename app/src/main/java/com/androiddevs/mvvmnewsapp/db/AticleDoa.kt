package com.androiddevs.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.entity.Article


@Dao
interface AticleDoa {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insert(article: Article):Long


    @Query("SELECT * FROM Articles")
    fun getall():LiveData<List<Article>>

    @Delete
    suspend fun deletearticel(article: Article)

}
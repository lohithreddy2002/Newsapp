package com.androiddevs.mvvmnewsapp.db

import androidx.room.TypeConverter
import com.androiddevs.mvvmnewsapp.entity.Source

class converters {

    @TypeConverter
    fun fromsource(source: Source):String{
        return source.name

    }
    @TypeConverter
    fun tosource(name:String): Source {
        return Source(name,name)
    }


}
package com.androiddevs.mvvmnewsapp.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androiddevs.mvvmnewsapp.entity.Article
import androidx.room.Database


@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(converters::class)
abstract class ADatabase:RoomDatabase() {

    abstract fun getDoa():AticleDoa

    companion object{
        @Volatile
        private var instance:ADatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?:synchronized(LOCK){
            instance ?: createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ADatabase::class.java,
            "article_db.db"
        ) .fallbackToDestructiveMigration().build()

    }


}
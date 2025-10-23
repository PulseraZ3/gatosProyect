package com.leoanrdo.gatosproyecto

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Post::class,
    ],
    version = 1
    )
abstract class AppDatabase: RoomDatabase() {
    abstract fun postDao(): PostDao

    companion object {
        private var INSTACE: AppDatabase? = null
        fun getOrCreateInstance(context: Context): AppDatabase{
            if(INSTACE == null){
                INSTACE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "post.db"
                ).build()
            }
            return INSTACE!!
        }
    }
}
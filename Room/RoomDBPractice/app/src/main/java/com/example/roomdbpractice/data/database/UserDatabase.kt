package com.example.roomdbpractice.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdbpractice.data.model.User
import com.example.roomdbpractice.logic.dao.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
abstract fun userDao():UserDao

companion object{
    @Volatile
     private var INSTANCE:UserDatabase? = null

    fun getDataBase(context: Context):UserDatabase{
        val tempInstance = INSTANCE
        if (tempInstance!=null){
            return tempInstance
        }
        synchronized(this){
        val instance = Room.databaseBuilder(context.applicationContext,
        UserDatabase::class.java,
            "user_database"
        ).build()
        INSTANCE = instance
        return instance
    }}
}
}
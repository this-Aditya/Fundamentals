package com.example.roomdbpractice.logic.repository

import android.util.Log
import com.example.roomdbpractice.data.model.User
import com.example.roomdbpractice.logic.dao.UserDao

class UserRepository(private val userDao: UserDao)
{
    val readAllUsers = userDao.readAllUsers()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
}
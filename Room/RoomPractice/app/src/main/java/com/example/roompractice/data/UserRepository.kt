package com.example.roompractice.data

import android.util.Log
import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllUsers()

    suspend fun addUsers(user: User) {
        userDao.addUser(user)
        Log.i("TAG", "addUsers: ")
}
}
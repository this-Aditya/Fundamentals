package com.example.roompractice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roompractice.data.User
import com.example.roompractice.data.UserDataBase
import com.example.roompractice.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewmodel(application: Application): AndroidViewModel(application) {

     val readAllData :LiveData<List<User>>
    private val repository :UserRepository

    init {
        val userDao = UserDataBase.getUserdataBase(application).userDao()
         repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }
    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
repository.addUsers(user)
        }
    }
}
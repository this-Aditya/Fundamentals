package com.example.roomdbpractice.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdbpractice.data.database.UserDatabase
import com.example.roomdbpractice.data.model.User
import com.example.roomdbpractice.logic.dao.UserDao
import com.example.roomdbpractice.logic.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val repository:UserRepository
    val readAllData :LiveData<List<User>>
    init {
        val userDao = UserDatabase.getDataBase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllUsers
    }
    fun addUser(user:User){
        viewModelScope.launch(Dispatchers.IO) {
        repository.addUser(user)
    }}
    fun updateUser(user:User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }
}
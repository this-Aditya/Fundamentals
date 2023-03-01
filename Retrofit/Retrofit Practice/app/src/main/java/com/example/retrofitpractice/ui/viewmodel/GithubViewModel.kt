package com.example.retrofitpractice.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitpractice.data.model.Users
import com.example.retrofitpractice.data.repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GithubViewModel: ViewModel() {
     val users :MutableLiveData<List<Users>> =MutableLiveData()
    fun fetchUsers() {
        viewModelScope.launch {
            var response = withContext(Dispatchers.IO){
                GithubRepository.getUsers()
            }
            if (response.isSuccessful){
                response.body().let {
                    users.postValue(it)
                }
            }

        }
    }
    fun searchUsers(name :String){
        viewModelScope.launch {
            var responseSearch = withContext(Dispatchers.IO){
                GithubRepository.searchUsers(name)
            }
            if (responseSearch.isSuccessful){
                users.postValue(responseSearch.body()?.items)
            }
        }
    }
}
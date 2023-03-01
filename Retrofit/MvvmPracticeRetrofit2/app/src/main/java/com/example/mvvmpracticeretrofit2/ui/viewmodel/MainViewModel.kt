package com.example.mvvmpracticeretrofit2.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmpracticeretrofit2.data.model.SearchUsers
import com.example.mvvmpracticeretrofit2.data.model.Users
import com.example.mvvmpracticeretrofit2.data.repository.Repository
import com.example.mvvmpracticeretrofit2.ui.view.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myUsers :MutableLiveData<Response<List<Users>>> = MutableLiveData()
    var mySearchUsers :MutableLiveData<Response<List<SearchUsers>>> = MutableLiveData()
    fun getUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("threadInfo", "Thread :${Thread.currentThread().name}")
          var response =  repository.getUsers()
            withContext(Dispatchers.Main){
                Log.i("threadInfo", "Thread :${Thread.currentThread().name}")

                myUsers.value = response}
        }
    }
    fun SearchUsers(name :String){
        viewModelScope.launch {
            var response = repository.searchUsers(name)
  mySearchUsers.value = response
        }
    }
}
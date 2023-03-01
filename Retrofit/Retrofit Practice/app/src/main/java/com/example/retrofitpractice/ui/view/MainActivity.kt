package com.example.retrofitpractice.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitpractice.R
import com.example.retrofitpractice.ui.viewmodel.GithubViewModel
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
val vm by lazy {
    ViewModelProvider(this).get(GithubViewModel::class.java)
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm.fetchUsers()
        vm.users.observe(this, Observer {
            for (i in 1..10) {
                Log.i(TAG, "${it.get(i)}")
            }})
    }
}
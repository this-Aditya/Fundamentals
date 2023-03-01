package com.example.viewmodelpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.viewmodelpractice.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
        var data = binding.root
        setContentView(data)

        var viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.starttimer()
        viewModel.seconds().observe(this,Observer{
            binding.textView.text = viewModel.seconds().toString()
        })
   viewModel.finished().observe(this,Observer{
       if (it){
           Toast.makeText(this,"Countown finshed ",Toast.LENGTH_LONG)
       }
   })
    } }
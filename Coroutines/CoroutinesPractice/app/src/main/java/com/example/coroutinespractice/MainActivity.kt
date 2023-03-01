package com.example.coroutinespractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.coroutinespractice.databinding.ActivityMainBinding
import com.example.coroutinespractice.fragment.FirstFragment
import com.example.coroutinespractice.fragment.SecondFragment
import kotlinx.coroutines.*
import javax.crypto.Mac
import kotlin.system.measureTimeMillis

private const val TAG = "App"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        val firstFragmet = FirstFragment()
        val secondFragment = SecondFragment()

       supportFragmentManager.beginTransaction().apply {
           replace(R.id.flFragment , firstFragmet)
           commit()
       }
        binding.btnFrg1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment , firstFragmet)
                commit()
            }
        }
        binding.btnFrg2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment , secondFragment)
                commit()
            }
        }
    }



}
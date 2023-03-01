package com.example.fragmentspractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentspractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var fragment1 = Fragment1()
        var fragment2 = Fragment2()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment1)
            commit()
        }

        binding.btnF1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,fragment1)
                commit()
            }
        }
        binding.btnF2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,fragment2)
                commit()
            }
        }
    }
}
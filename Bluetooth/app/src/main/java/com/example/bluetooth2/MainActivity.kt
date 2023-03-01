package com.example.bluetooth2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bluetooth2.databinding.ActivityMainBinding
import android.Manifest
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val permissions = arrayOf(Manifest.permission.BLUETOOTH,
        Manifest.permission.BLUETOOTH_CONNECT,
        Manifest.permission.BLUETOOTH_ADMIN,
        Manifest.permission.BLUETOOTH_SCAN ,
        Manifest.permission.BLUETOOTH_ADVERTISE,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
    )

    val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){results->
        results.forEach { result->
           if (result.value){

           }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
package com.example.bluetoothi

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.bluetoothi.databinding.ActivityMainBinding
import java.security.Permissions

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val On = binding.btnOn
    val Off = binding.btnOff
    val ShowListPaired = binding.btnPaired
    val ShowListNearby = binding.btnNearby
    lateinit var bluetoothAdapter: BluetoothAdapter

    val requestPermissionsLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){isGranted:Map<String,Boolean>->

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bluetoothManager = getSystemService(BluetoothManager::class.java)
        bluetoothAdapter = bluetoothManager.adapter
        binding.btnOn.setOnClickListener{
            requestBluetoothPermmissions()
        }
    }

    private fun requestBluetoothPermmissions() {
val Permissions: () -> String = {
            android.Manifest.permission.BLUETOOTH_CONNECT
            android.Manifest.permission.BLUETOOTH_SCAN }

        when{
    ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT)->{

    }
}
    }
}
package com.example.permissions2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.permissions2.databinding.ActivityMainBinding
import com.example.permissions2.databinding.DialogueBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val permissions = arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    )
    { isGranted ->
        isGranted.forEach { requestResult ->
            if (requestResult.value) {
                Log.i("TAG", "value: ${requestResult.value}  key : ${requestResult.key} ")
            } else {
                Log.i("TAG", "value: ${requestResult.value}  key : ${requestResult.key} ")
            }
        }
    }

    private fun updateUIfalse() {
        binding.button.isVisible = true
        binding.textview.isVisible = false
    }

    private fun updateUI() {
        binding.button.isVisible = false
        binding.textview.isVisible = true    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
                requestPermissionsFromApp()
            }
            else{
                dowork()
            }
        }
    }

    private fun dowork() {
        Log.i(TAG, "Work is being done ")
//        Toast.makeText(this,"Hello Work is being performed",Toast.LENGTH_SHORT).show()
    }

    private fun requestPermissionsFromApp() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                permissions[0]
            ) == PackageManager.PERMISSION_GRANTED -> {
                Log.i(TAG, "permission already granted for camera ")
            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CAMERA
            ) -> {
                Log.i(TAG, "showing rational request ")
                AlertDialog.Builder(this).setView(
                    DialogueBinding.inflate(layoutInflater).root
                ).setPositiveButton("Yes"){dialogue,which->
                    requestPermissionLauncher.launch(permissions)
                    Log.i(TAG, "again requesting permission for rational ")
                }.setNegativeButton("No"){dialogue,which->
                    Log.i(TAG, "Permisison denied for rational ")
                }.show()
            }
            else -> {
                Log.i(TAG, "not asked for permissions.")
                requestPermissionLauncher.launch(permissions)
            }
        }

        when {
            ContextCompat.checkSelfPermission(
                this,
                permissions[1]
            ) == PackageManager.PERMISSION_GRANTED -> {
                Log.i(TAG, "permission already granted for coarse location")
            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) -> {
                Log.i(TAG, "showing rational request for location")
                AlertDialog.Builder(this).setView(
                  R.layout.dialogue
                ).setPositiveButton("Yes"){dialogue,which->
                    requestPermissionLauncher.launch(permissions)
                    Log.i(TAG, "again requesting permission for rational location")
                }.setNegativeButton("No"){dialogue,which->
                    Log.i(TAG, "Permisison denied for rational location ")
                }.show()
            }
            else -> {
                Log.i(TAG, "not asked for permissions.location ")
                requestPermissionLauncher.launch(permissions)
            }
        }
    }
}
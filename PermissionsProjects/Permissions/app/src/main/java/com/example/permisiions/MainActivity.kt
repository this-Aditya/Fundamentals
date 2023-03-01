package com.example.permisiions
import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.permisiions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding
    val permissions = arrayOf(Manifest.permission.READ_CONTACTS,
    Manifest.permission.CAMERA)
    val requestCode = 123
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { result ->
         result.entries.forEach{resultStatus->
                if (resultStatus.value)
            Log.i(TAG, "PermissionGranted: for ${resultStatus.key} and permission is ${resultStatus.value}")
         else {
            Log.i(TAG, "Permission denied: for ${resultStatus.key} and permission is ${resultStatus.value}")
        }
         }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.permissions.setOnClickListener {
requestPermissionLauncher.launch(permissions)

        }

    }

//    private fun requestPermissions() {
//        when {
//            ContextCompat.checkSelfPermission(
//                this,
//                Manifest.permission.READ_CONTACTS
//            ) == PackageManager.PERMISSION_GRANTED -> {
//                Log.i(TAG, "Permission is already granted ")
//            }
//            ActivityCompat.shouldShowRequestPermissionRationale(this
//                ,Manifest.permission.READ_CONTACTS)->{
//                   Toast.makeText(this,"App Might Misbehave",Toast.LENGTH_SHORT).show()
//                requestPermissionLauncher.launch(Manifest.permission.READ_CONTACTS)
//                }
//            else->{
//                requestPermissionLauncher.launch(Manifest.permission.READ_CONTACTS)
//            }
//        }
//
//    }
}

//
//    private fun hasWriteExternalStoragePermissions() = ActivityCompat.checkSelfPermission(
//        this, Manifest.permission.WRITE_EXTERNAL_STORAGE
//    ) == PackageManager.PERMISSION_GRANTED
//
//    private fun hasForeroundLocationPermissions() = ActivityCompat.checkSelfPermission(
//        this, Manifest.permission.ACCESS_COARSE_LOCATION
//    ) == PackageManager.PERMISSION_GRANTED
//
//    private fun hasBackgroundLocationPermissions() = ActivityCompat.checkSelfPermission(
//        this, Manifest.permission.ACCESS_BACKGROUND_LOCATION
//    ) == PackageManager.PERMISSION_GRANTED
//
//    private fun requestPermissions() {
//        Log.i("MainActivity", "requestPermissions: ")
//        val permissionsToRequest = mutableListOf<String>()
//        if (!hasWriteExternalStoragePermissions()) {
//            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//        }
//        if (!hasForeroundLocationPermissions()) {
//            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
//        }
//        if (!hasBackgroundLocationPermissions()) {
//            permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
//        }
//        if (permissionsToRequest.isNotEmpty()) {
//            ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 225)
//        }
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == 225 && grantResults.isNotEmpty()) {
//            for (i in grantResults.indices) {
//                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
//                    Log.i("MainActivity", "Permission Accepted ${grantResults.get(i)}")
//                }
//            }
//        }
//    }

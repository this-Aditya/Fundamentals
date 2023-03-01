package com.example.broadcastreciever

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
lateinit var reciever1 : AirplaneModeChangedReciever
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reciever1 = AirplaneModeChangedReciever()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(reciever1,it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(reciever1)
    }
}
package com.example.broadcastreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangedReciever: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("hello",false)?:return
        if (isAirplaneModeEnabled){
            Toast.makeText(context,"Airplane Mode Is Enabled",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context,"Airplane Mode Is Disabled",Toast.LENGTH_SHORT).show()
        }
    }

}

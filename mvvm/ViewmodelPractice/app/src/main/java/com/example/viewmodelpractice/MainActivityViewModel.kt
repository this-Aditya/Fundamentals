package com.example.viewmodelpractice

import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

  lateinit var timer : CountDownTimer
private var seconds = MutableLiveData<Int>()
    private  var finished= MutableLiveData<Boolean>()
    fun seconds() = seconds
    fun finished() = finished
  fun starttimer(){
      timer = object :CountDownTimer(10000,1000){
          override fun onTick(p0: Long) {
              val timeLeft = p0/1000
       seconds.value = timeLeft.toInt()
          }

          override fun onFinish() {
              finished.value = true
          }

      }.start()
  }
}
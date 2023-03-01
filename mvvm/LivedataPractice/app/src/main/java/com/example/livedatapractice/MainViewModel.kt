package com.example.livedatapractice

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    lateinit var timer:CountDownTimer
    private var seconds =MutableLiveData<Int>()
    fun seconds() = seconds
    private  var isFinished = MutableLiveData<Boolean>()
    fun isFinsihed() = isFinished
    fun startTimer(time:Long) {
        timer = object : CountDownTimer(time, 1000) {
            override fun onTick(p0: Long) {
                var timeLeft = p0 / 1000
                seconds.value = timeLeft.toInt()
            }

            override fun onFinish() {
                isFinished.value = true
            }
        }.start()
    }    fun stopTimer(){
            timer.cancel()
        }

}
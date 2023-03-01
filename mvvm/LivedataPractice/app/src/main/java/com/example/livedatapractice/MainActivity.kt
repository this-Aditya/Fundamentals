package com.example.livedatapractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.livedatapractice.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val data = binding.root
        setContentView(data)
var viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        binding.btnStart.setOnClickListener {
//            Log.i(TAG, "onCreate: "
        var time = (binding.ettimeTaker.text.toString().toLong()+1)*1000
            viewModel.startTimer(time)
            binding.ettimeTaker.text.clear()
            inputMethodManager.hideSoftInputFromWindow(binding.ettimeTaker.windowToken, 0)
            binding.ettimeTaker.clearFocus()

            viewModel.seconds().observe(this, Observer {
                binding.Time.text = viewModel.seconds().value.toString()
            })
        }
        viewModel.isFinsihed().observe(this, Observer {
            if (it){
                Toast.makeText(this,"Finished",Toast.LENGTH_LONG).show()
            }
        })
        binding.btnStop.setOnClickListener {
            viewModel.stopTimer()
            binding.Time.text ="0"
        }
    }
}
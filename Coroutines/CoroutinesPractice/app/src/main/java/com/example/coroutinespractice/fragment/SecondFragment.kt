package com.example.coroutinespractice.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinespractice.R
import com.example.coroutinespractice.databinding.FragmentSecondBinding
private const val TAG = "App"
private lateinit var binding: FragmentSecondBinding
class SecondFragment : Fragment(R.layout.fragment_second) {
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        Log.i(TAG, "Container: $container , Inflator: $layoutInflater")
//        binding= FragmentSecondBinding.inflate(inflater,container,false)
//        return  binding.root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
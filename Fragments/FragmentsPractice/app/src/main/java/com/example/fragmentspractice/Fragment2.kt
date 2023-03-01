package com.example.fragmentspractice

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentspractice.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    lateinit var binding: Fragment2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = Fragment2Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("TAG", "onViewCreated: ")
        super.onViewCreated(view, savedInstanceState)
binding.f2.setBackgroundColor(Color.CYAN)
    binding.tvf2.text = "Fragment 2 "
    }
}
package com.example.navigationbasic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationbasic.databinding.Fragment1Binding

class Fragment1 :Fragment() {
lateinit var binding: Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= Fragment1Binding.inflate(inflater,container,false)
        binding.tvf1.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment2(45)
            Navigation.findNavController(binding.root).navigate(action)
        }
        return binding.root
    }
}

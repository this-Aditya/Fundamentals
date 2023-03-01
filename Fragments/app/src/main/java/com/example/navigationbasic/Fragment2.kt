package com.example.navigationbasic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

import com.example.navigationbasic.databinding.Fragment1Binding
import com.example.navigationbasic.databinding.Fragment2Binding

class Fragment2 :Fragment() {
    val args:Fragment2Args by navArgs()
    lateinit var binding: Fragment2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= Fragment2Binding.inflate(inflater,container,false)
        var mynum = args.number
        binding.tvf2.text = mynum.toString()
        binding.tvf2.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_fragment2_to_fragment1)
        }
        return binding.root
    }
}

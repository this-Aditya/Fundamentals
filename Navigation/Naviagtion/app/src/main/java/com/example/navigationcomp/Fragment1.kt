package com.example.navigationcomp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.navigationcomp.databinding.Fragment1Binding
val TAG = "ACTIVITY"
class Fragment1 : Fragment() {

lateinit var binding: Fragment1Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.i(TAG, "onCreateView: 1")
       binding = Fragment1Binding.inflate(inflater,container,false)
        val view = binding.root
           binding.btn.setOnClickListener {
               var fn = binding.etFirstName.text.toString()
               var ln = binding.etLastNAme.text.toString()
               var user = user(fn,ln)
               var action = Fragment1Directions.actionFragment1ToFragment2(user)
               view.findNavController().navigate(action)
           }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "onViewCreated: 1")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: 1")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "onDestroyView: 1")
    }

}
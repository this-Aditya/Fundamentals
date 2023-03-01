package com.example.navigationcomp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationcomp.databinding.Fragment1Binding
import com.example.navigationcomp.databinding.Fragment2Binding


class Fragment2 : Fragment() {
val args :Fragment2Args by navArgs()
    lateinit var binding: Fragment2Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = Fragment2Binding.inflate(inflater,container,false)
        val view = binding.root
        Log.i(TAG, "onCreateView: 2")
        var fn = args.data.firstName
        var ln = args.data.lastName
        binding.tvf2.text = "FirstName: $fn\n LastName: $ln"
        binding.tvf2.setOnClickListener {
            view.findNavController().navigate(R.id.action_fragment2_to_fragment1)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "onViewCreated: 2")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: 2")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "onDestroyView: 2")
    }

}
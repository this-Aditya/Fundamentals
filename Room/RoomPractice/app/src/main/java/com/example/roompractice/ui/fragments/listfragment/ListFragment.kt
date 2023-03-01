package com.example.roompractice.ui.fragments.listfragment

import android.media.metrics.LogSessionId
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roompractice.R
import com.example.roompractice.data.User
import com.example.roompractice.databinding.FragmentListBinding
import com.example.roompractice.viewmodel.UserViewmodel

class ListFragment : Fragment() {
    lateinit var userViewModel :UserViewmodel
    lateinit var binding: FragmentListBinding
     var allUsers:MutableList<User> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)
        var view = binding.root
//        binding.rvListfrg.adapter = ListFragmentAdapter(requireContext(),allUsers)
//        val adapter = binding.rvListfrg.adapter
//        binding.rvListfrg.layoutManager=LinearLayoutManager(requireContext())
//        userViewModel = ViewModelProvider(this).get(UserViewmodel::class.java)
//        userViewModel.readAllData.observe(requireActivity(),Observer{
//            allUsers.addAll(it)
//           adapter?.notifyDataSetChanged()
//            allUsers.forEach {
//                Log.i("TAG", "${it.id}")
//                Log.i("TAG", "${it.age}")
//                Log.i("TAG", "${it.firstname}")
//                Log.i("TAG", "${it.lastName}")
//            }      })
        binding.fabAddUser.setOnClickListener {
            view.findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return binding.root
    }

}
package com.example.roomdbpractice.ui.fragment.list

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
import com.example.roomdbpractice.R
import com.example.roomdbpractice.data.model.User
import com.example.roomdbpractice.databinding.FragmentListBinding
import com.example.roomdbpractice.ui.fragment.update.UpdateFragmentDirections
import com.example.roomdbpractice.ui.viewmodel.UserViewModel

class ListFragment : Fragment() {
    private val TAG = "App"
    lateinit var binding: FragmentListBinding
    lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root
        var users = mutableListOf<User>()
        binding.rvList.layoutManager = LinearLayoutManager(requireContext())

        var adapter = binding.rvList.adapter

        binding.rvList.adapter = UserAdapter(requireContext(), users,object:UserAdapter.OnItemClicked{
            override fun itemClicked(position:Int) {
                val user = users[position]
                 val action =ListFragmentDirections.actionListFragmentToUpdateFragment(user)
                view.findNavController().navigate(action)
                binding.rvList.adapter?.notifyDataSetChanged()
            }
        })


        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.readAllData.observe(requireActivity(), Observer {
            Log.i(TAG, "1 ${users.size}")
            users.clear()
            Log.i(TAG, "2 ${users.size}")
            users.addAll(it)
            Log.i(TAG, "3 ${users.size}")
            adapter?.notifyDataSetChanged()
            Log.i(TAG, "4 ${users.size}")
            Log.i(TAG, "onCreateView: ")
        })


        binding.floatingActionButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_listFragment_to_addFragment)

        }

        return view
    }


}
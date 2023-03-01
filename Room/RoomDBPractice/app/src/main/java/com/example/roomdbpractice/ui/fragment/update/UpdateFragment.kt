package com.example.roomdbpractice.ui.fragment.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomdbpractice.R
import com.example.roomdbpractice.data.model.User
import com.example.roomdbpractice.databinding.FragmentUpdateBinding
import com.example.roomdbpractice.ui.viewmodel.UserViewModel

class UpdateFragment : Fragment() {
    private  val args by navArgs<UpdateFragmentArgs>()
lateinit var binding: FragmentUpdateBinding
lateinit var userViewModel:UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentUpdateBinding.inflate(inflater,container,false)
        val view = binding.root
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val user =args.data
        binding.etFirstName.setText(user.firstName)
        binding.etLastName.setText(user.lastName)
        binding.etAge.setText(user.age.toString())

        binding.btnUpdate.setOnClickListener {
            val update= User(user.id,binding.etFirstName.text.toString(),binding.etLastName.text.toString(),
            binding.etAge.text.toString().toInt()
                )
            userViewModel.updateUser(update)
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        return view
        }

}
package com.example.roomdbpractice.ui.fragment.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.roomdbpractice.R
import com.example.roomdbpractice.data.model.User
import com.example.roomdbpractice.databinding.FragmentAddBinding
import com.example.roomdbpractice.ui.viewmodel.UserViewModel

class AddFragment : Fragment() {
    private val TAG: String= "Add"
    lateinit var binding: FragmentAddBinding
    lateinit var userViewModel :UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root
        userViewModel= ViewModelProvider(this).get(UserViewModel::class.java)
        binding.btnAdd.setOnClickListener {
            addUserToDataBase()
            view.findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        return view
    }

    private fun addUserToDataBase() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val age = binding.etAge.text
        if (!fields(firstName,lastName,age)){
            val user = User(0,firstName,lastName,age.toString().toInt())
            userViewModel.addUser(user)
        }
        else{
            Toast.makeText(requireContext(),"Not a Valid Input ",Toast.LENGTH_SHORT).show()
        }
    }
    private fun fields(firstName: String, lastName: String, age: Editable): Boolean{
        return (TextUtils.isEmpty(firstName)&&TextUtils.isEmpty(lastName)&&age.isEmpty())
    }


}
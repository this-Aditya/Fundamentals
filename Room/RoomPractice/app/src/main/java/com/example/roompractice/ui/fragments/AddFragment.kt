package com.example.roompractice.ui.fragments

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
import com.example.roompractice.R
import com.example.roompractice.data.User
import com.example.roompractice.databinding.FragmentAddBinding
import com.example.roompractice.viewmodel.UserViewmodel

class AddFragment : Fragment() {
lateinit var binding: FragmentAddBinding
lateinit var userViewModel : UserViewmodel
override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater,container,false)
     var view = binding.root
    userViewModel = ViewModelProvider(this).get(UserViewmodel::class.java)
        binding.btnAddDetails.setOnClickListener {

            addTodataBase()
            view.findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }


        return binding.root
    }

    private fun addTodataBase() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val age= binding.etage.text

        if (InputCheck(firstName,lastName,age)){
            var user = User(1,firstName,lastName,age.toString().toInt())
            userViewModel.addUser(user)
        }
        else{
            Toast.makeText(requireContext(),"Enter the valid Input",Toast.LENGTH_SHORT).show()
            return
        }


    }

    private fun InputCheck(firstName: String, lastName: String, age: Editable) :Boolean{
//        return!(firstName.trim().isEmpty()&&lastName.trim().isEmpty()&&age.trim().isEmpty())
 return !((TextUtils.isEmpty(firstName))&&(TextUtils.isEmpty(lastName))&&(age.isEmpty()))
    }
}
package com.example.coroutinespractice.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.coroutinespractice.R
import com.example.coroutinespractice.databinding.FragmentFirstBinding

private lateinit var binding: FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentFirstBinding.inflate(inflater,container,false)
//        return binding.root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId== R.menu.mi_back){
            gotoFirstFragment()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun gotoFirstFragment() {

    }
}
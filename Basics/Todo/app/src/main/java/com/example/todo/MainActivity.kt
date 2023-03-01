package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.databinding.ActivityMainBinding

data class tasks(var work:String,var ischecked:Boolean)

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        val data = binding.root
        setContentView(data)
        var store= mutableListOf<tasks>()
        store=getlist()
        binding.rvMain.adapter = TaskAdapter(store,this)
        binding.rvMain.layoutManager= LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener{
            var taskk= binding.etAddTodo.text.toString()
            store.add(tasks(taskk,false))
            binding.etAddTodo.text.clear()
             TaskAdapter(store,this).notifyItemInserted(store.size-1)
        }

    }

    fun getlist(): MutableList<tasks> {
        var store = mutableListOf<tasks>()
        store.add(tasks("Do Meditate ",true))
        store.add(tasks("Take Bath  ",false))
        store.add(tasks("Eat Breakfast  ",false))
        store.add(tasks("check Yesterday Work  ",true))
    return  store
    }
}
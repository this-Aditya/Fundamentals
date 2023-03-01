package com.example.todo

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(var store: List<tasks>,var context: Context) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {

val view = LayoutInflater.from(context).inflate(R.layout.item_todo,parent,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
val task = store[position]
        holder.bindView(task)
    }

    override fun getItemCount(): Int {
return store.size
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var work1 = itemView.findViewById<TextView>(R.id.tvItemToDo)
        var ischecked1= itemView.findViewById<CheckBox>(R.id.checkBox)
        fun bindView(task:tasks){
            work1.text= task.work
            ischecked1.isSelected=task.ischecked
        }
    }

}

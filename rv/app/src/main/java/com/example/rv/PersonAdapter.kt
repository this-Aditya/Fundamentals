package com.example.rv

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PersonAdapter(val context: Context, val persons: MutableList<Person>) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvname = itemView.findViewById<TextView>(R.id.tvName)
        val tvage = itemView.findViewById<TextView>(R.id.tvage)
        fun binddata(person: Person) {
            Log.i(TAG, "itemview: $itemView")
            tvname.text = person.name
            tvage.text = "Age:${person.Age}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        Log.i(TAG, "Parent: $parent")
        val view = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        Log.i(TAG, "Holder : $holder")
        val person = persons[position]
        holder.binddata(person)
    }

    override fun getItemCount(): Int {
        return persons.size
    }
}

package com.example.roomdbpractice.ui.fragment.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbpractice.data.model.User
import com.example.roomdbpractice.databinding.RowLayoutBinding


class UserAdapter(var context: Context,var  users: MutableList<User>,var onItemClicked: OnItemClicked): RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    interface OnItemClicked{
        fun itemClicked(position: Int)
    }

class MyViewHolder(val binding: RowLayoutBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindata(user: User) {
binding.tvFirstName.text = user.firstName.toString()
binding.tvLastName.text = user.lastName.toString()
binding.tvage.text = user.age.toString()
binding.tvId.text = user.id.toString()
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
var user = users[position]
    holder.bindata(user)
        holder.binding.clRowLayout.setOnClickListener {
            onItemClicked.itemClicked(position)
        }
    }

    override fun getItemCount(): Int {
return users.size   }

}










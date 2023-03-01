//package com.example.roompractice.ui.fragments.listfragment
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.roompractice.data.User
//import com.example.roompractice.databinding.ExampleRowListBinding
//
//class ListFragmentAdapter(val context: Context, val allUsers: MutableList<User>) : RecyclerView.Adapter<ListFragmentAdapter.MyViewHolder>() {
//class MyViewHolder(val binding:ExampleRowListBinding): RecyclerView.ViewHolder(binding.root) {
//    fun bindata(user: User) {
//binding.tvFirstName.text = user.firstname.toString()
//binding.tvLastName.text = user.lastName.toString()
//binding.tvAge.text = user.age.toString()
//binding.tvid.text = user.id.toString()
//    }
//}
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        return MyViewHolder(ExampleRowListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        var user = allUsers[position]
//        holder.bindata(user)
//
//    }
//
//    override fun getItemCount(): Int {
//return allUsers.size   }
//
//}
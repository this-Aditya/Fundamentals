package com.example.rv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rv.databinding.ActivityMainBinding
data class Person(val name:String,val Age:Int)
val TAG = "App"
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var person = mutableListOf<Person>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        person = getPersons()
        Log.i(TAG, "$this")
binding.rvPerson.adapter = PersonAdapter(this,person)
        binding.rvPerson.layoutManager = LinearLayoutManager(this)
    }

    private fun getPersons(): MutableList<Person> {
        val person= mutableListOf<com.example.rv.Person>()
for (i in 1..100){
   person.add(Person("Person$i",i))
}
        return person
    }
}
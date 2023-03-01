package com.example.roompractice.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val firstname:String,
    val lastName:String,
    var age :Int
)
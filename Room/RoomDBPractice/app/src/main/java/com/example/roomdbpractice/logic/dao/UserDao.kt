package com.example.roomdbpractice.logic.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdbpractice.data.model.User

@Dao
interface UserDao {


    @Query("select * from user_table order by id asc ")
    fun readAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)
}
package com.example.retrofitpractice.data.repository

import com.example.retrofitpractice.data.api.Client

object GithubRepository {
    suspend fun getUsers() = Client.api.getusers()
    suspend fun searchUsers(name :String) = Client.api.searchusers(name)
}
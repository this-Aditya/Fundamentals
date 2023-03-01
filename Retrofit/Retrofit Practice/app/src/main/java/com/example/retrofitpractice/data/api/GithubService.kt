package com.example.retrofitpractice.data.api

import com.example.retrofitpractice.data.model.SearchResponse
import com.example.retrofitpractice.data.model.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
@GET("/users")
suspend fun getusers():Response<List<Users>>
@GET("/search/users")
suspend fun searchusers(
    @Query("q") name :String
):Response<SearchResponse>
}

package com.example.fakeapifetching

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BlogServiceProvider {
    @GET("/users/{id}")
    suspend fun getUSer(
        @Path("id") userId:Int
    ) : User
    @GET("/posts/{id}")
    suspend fun getPost(
        @Path("id") PostId:Int
    ):Post
    @GET("users/{id}/posts")
   suspend  fun getPostByUser(
        @Path("id") userId:Int
    ):List<Post>
}
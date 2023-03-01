package com.example.fakeapifetching

import com.google.gson.annotations.SerializedName

data class User(
    var id : Int ,
    var name :String,
    var email:String
)
data class Post(
    var id :Int,
    @SerializedName("userId") var UserId :Int,
    var title :String

)
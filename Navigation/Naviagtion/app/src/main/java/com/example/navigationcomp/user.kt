package com.example.navigationcomp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class user(
    val firstName:String,
    val lastName :String
): Parcelable

package com.example.catraksi_project.Model

import com.google.gson.annotations.SerializedName

data class RegisterAplikasi(
    @SerializedName("nama_pengguna")
    val nama_pengguna: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String
)
package com.example.catraksi_project.Model

import com.google.gson.annotations.SerializedName

data class LoginAplikasi (
        @SerializedName("nama_pengguna")
        var nama_pengguna: String,
        @SerializedName("password")
        var password: String
        )
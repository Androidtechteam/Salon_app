package com.lnd.salon.presentation.models


import com.google.gson.annotations.SerializedName

data class LoginResponseMode(
    @SerializedName("email")
    var email: String,
    @SerializedName("expiresAt")
    var expiresAt: Int,
    @SerializedName("fullName")
    var fullName: String,
    @SerializedName("oauthToken")
    var oauthToken: String
)
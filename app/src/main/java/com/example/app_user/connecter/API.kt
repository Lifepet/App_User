package com.example.app_user.connecter

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface API {
    @POST("auth/join/")
    fun join(@Body body: Any): Call<Void>
}
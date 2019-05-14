package com.example.app_user.connecter

import com.example.app_user.model.AdoptListModel
import com.example.app_user.model.LoginModel
import com.example.app_user.model.ProtectModel
import retrofit2.Call
import retrofit2.http.*

interface API {
    @POST("auth/join/")
    fun join(@Body body: Any): Call<Void>

    @POST("auth/login/")
    fun login(@Body body: Any): Call<LoginModel>

    @GET("post/adoption/")
    @Headers("Content-Type: application/json")
    fun getAdopt(@Header("Authorization") token: String): Call<ArrayList<AdoptListModel>>

    @GET("post/adoption/{post_id}")
    @Headers("Content-Type: application/json")
    fun getAdoptDetail(@Header("Authorization") token: String, @Path("post_id") post_id: String): Call<AdoptListModel>

    @GET("post/care/")
    @Headers("Content-Type: application/json")
    fun getProtect(@Header("Authorization") token: String): Call<ArrayList<ProtectModel>>

    @GET("post/care/{post_id}")
    @Headers("Content-Type: application/json")
    fun getProtectDetail(@Header("Authorization") token: String, @Path("post_id") post_id: String): Call<ProtectModel>
}
package com.example.app_user.connecter

import com.example.app_user.model.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST


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

    @POST("post/community/")
    @Multipart
    fun postReview(
        @Header("Authorization") token: String, @Part("title") title: RequestBody, @Part("content") content: RequestBody,
        @Part image: MultipartBody.Part
    ): Call<Unit>

    @GET("post/community/")
    @Headers("Content-Type: application/json")
    fun getReview(@Header("Authorization") token: String): Call<ArrayList<ReviewModel>>

    @GET("post/community/{post_id}")
    @Headers("Content-Type: application/json")
    fun getReviewDetail(@Header("Authorization") token: String, @Path("post_id") post_id: String): Call<ReviewModel>

    @GET("post/move/")
    @Headers("Content-Type: application/json")
    fun getVolunteer(@Header("Authorization") token: String): Call<ArrayList<VolunteerModel>>

    @GET("post/move/{post_id}")
    @Headers("Content-Type: application/json")
    fun getVolunteerDetail(@Header("Authorization") token: String, @Path("post_id") post_id: String): Call<VolunteerModel>

    @GET("post/report/")
    @Headers("Content-Type: application/json")
    fun getReport(@Header("Authorization") token: String): Call<ArrayList<ReportModel>>

    @GET("post/report/{post_id}")
    @Headers("Content-Type: application/json")
    fun getReportDetail(@Header("Authorization") token: String, @Path("post_id") post_id: String): Call<ReportModel>

    @GET("post/find/")
    @Headers("Content-Type: application/json")
    fun getLost(@Header("Authorization") token: String): Call<ArrayList<LostModel>>

    @GET("post/find/{post_id}")
    @Headers("Content-Type: application/json")
    fun getLostDetail(@Header("Authorization") token: String, @Path("post_id") post_id: String): Call<LostModel>

    @POST("/apply/adoption/{apply_id}")
    @Headers("Content-Type: application/json")
    fun postAdoptApply(@Header("Authorization") token: String, @Path("apply_id") apply_id: String, @Body body: Any): Call<Unit>

    @POST("/apply/care/{apply_id}")
    @Headers("Content-Type: application/json")
    fun postProtectApply(@Header("Authorization") token: String, @Path("apply_id") apply_id: String, @Body body: Any): Call<Unit>

    @POST("/apply/move/{apply_id}")
    @Headers("Content-Type: application/json")
    fun postFindApply(@Header("Authorization") token: String, @Path("apply_id") apply_id: String, @Body body: Any): Call<Unit>

    @POST("post/find/")
    @Multipart
    fun postFind(
        @Header("Authorization") token: String, @Part("title") title: RequestBody, @Part("sex") sex: RequestBody, @Part(
            "pet_name"
        ) pet_name: RequestBody, @Part("content") content: RequestBody, @Part("type") type: RequestBody,
        @Part image: MultipartBody.Part
    ): Call<Unit>

    @POST("post/report/")
    @Multipart
    fun postReport(
        @Header("Authorization") token: String, @Part("title") title: RequestBody, @Part("current_location") current_location: RequestBody, @Part(
            "content"
        ) content: RequestBody,
        @Part image: MultipartBody.Part
    ): Call<Unit>

    @POST("/comment/adoption/{post_id}")
    @Headers("Content-Type: application/json")
    fun postAdoptComment(@Header("Authorization") token: String, @Path("post_id") post_id: String, @Body body: Any): Call<Unit>

    @GET("/comment/adoption/{post_id}")
    @Headers("Content-Type: application/json")
    fun getComment(@Header("Authorization") token: String, @Path("post_id") post_id: String): Call<ArrayList<AdoptCommentModel>>

    @POST("/comment/care/{post_id}")
    @Headers("Content-Type: application/json")
    fun postProtectComment(@Header("Authorization") token: String, @Path("post_id") post_id: String, @Body body: Any): Call<Unit>

    @POST("/comment/report/{post_id}")
    @Headers("Content-Type: application/json")
    fun postReportComment(@Header("Authorization") token: String, @Path("post_id") post_id: String, @Body body: Any): Call<Unit>

    @POST("/comment/find/{post_id}")
    @Headers("Content-Type: application/json")
    fun postLostComment(@Header("Authorization") token: String, @Path("post_id") post_id: String, @Body body: Any): Call<Unit>

    @POST("/comment/community/{post_id}")
    @Headers("Content-Type: application/json")
    fun postReviewComment(@Header("Authorization") token: String, @Path("post_id") post_id: String, @Body body: Any): Call<Unit>

    @POST("/comment/move/{post_id}")
    @Headers("Content-Type: application/json")
    fun postVolunteerComment(@Header("Authorization") token: String, @Path("post_id") post_id: String, @Body body: Any): Call<Unit>
}
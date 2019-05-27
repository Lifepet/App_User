package com.example.app_user.ui.detailProtect

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.AdoptCommentModel
import com.example.app_user.model.AdoptListModel
import com.example.app_user.model.ProtectCommentModel
import com.example.app_user.model.ProtectModel
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailProtectViewModel(val app: Application) : AndroidViewModel(app) {
    val protectModel = MutableLiveData<ProtectModel>()
    val postId = MutableLiveData<String>()
    val gotoApply = SingleLiveEvent<Any>()
    val protectCommentModel=MutableLiveData<ArrayList<ProtectCommentModel>>()

    fun getProtectDetail() {
        Connecter.api.getProtectDetail(getToken(app.applicationContext), postId.value!!)
            .enqueue(object : Callback<ProtectModel> {
                override fun onResponse(call: Call<ProtectModel>, response: Response<ProtectModel>) {
                    protectModel.value = response.body()
                }

                override fun onFailure(call: Call<ProtectModel>, t: Throwable) {

                }

            })
    }

    fun gotoApply(){
        gotoApply.call()
    }

    val gotoComment = SingleLiveEvent<Any>()

    fun gotoComment() {
        gotoComment.call()
    }

    fun getProtectComment() {
        Connecter.api.getProtectComment(getToken(app.applicationContext), postId.value!!)
            .enqueue(object : Callback<ArrayList<ProtectCommentModel>> {

                override fun onResponse(
                    call: Call<ArrayList<ProtectCommentModel>>,
                    response: Response<ArrayList<ProtectCommentModel>>
                ) {
                    protectCommentModel.value = response.body()
                }

                override fun onFailure(call: Call<ArrayList<ProtectCommentModel>>, t: Throwable) {

                }
            })
    }
}
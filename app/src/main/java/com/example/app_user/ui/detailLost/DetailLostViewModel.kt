package com.example.app_user.ui.detailLost

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.LostModel
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailLostViewModel(val app: Application) : AndroidViewModel(app) {
    val lostModel = MutableLiveData<LostModel>()
    val postId = MutableLiveData<String>()

    fun getLostDetail() {
        Connecter.api.getLostDetail(getToken(app.applicationContext), postId.value.toString())
            .enqueue(object : Callback<LostModel> {

                override fun onResponse(call: Call<LostModel>, response: Response<LostModel>) {
                    lostModel.value = response.body()
                }

                override fun onFailure(call: Call<LostModel>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })

    }

    val gotoComment = SingleLiveEvent<Any>()

    fun gotoComment() {
        gotoComment.call()
    }
}
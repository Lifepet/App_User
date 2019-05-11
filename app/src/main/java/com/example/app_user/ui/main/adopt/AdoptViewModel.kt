package com.example.app_user.ui.main.adopt

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.AdoptListModel
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdoptViewModel(val app: Application) : AndroidViewModel(app) {
    val adoptModel = MutableLiveData<AdoptListModel>()

    fun getAdopt() {
        Connecter.api.getAdopt(getToken(app.applicationContext)).enqueue(object : Callback<AdoptListModel> {
            override fun onResponse(call: Call<AdoptListModel>, response: Response<AdoptListModel>) {
                when(response.code()){
                    200-> adoptModel.value=response.body()
                }
            }

            override fun onFailure(call: Call<AdoptListModel>, t: Throwable) {

            }
        })
    }
}
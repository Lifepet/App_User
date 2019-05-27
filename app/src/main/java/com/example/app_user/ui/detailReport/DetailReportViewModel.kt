package com.example.app_user.ui.detailReport

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.ReportModel
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailReportViewModel(val app: Application) : AndroidViewModel(app) {

    val reportModel = MutableLiveData<ReportModel>()
    val postId = MutableLiveData<String>()

    fun getReportDetail() {
        Connecter.api.getReportDetail(getToken(app.applicationContext), postId.value!!)
            .enqueue(object : Callback<ReportModel> {

                override fun onResponse(call: Call<ReportModel>, response: Response<ReportModel>) {
                    reportModel.value=response.body()
                }

                override fun onFailure(call: Call<ReportModel>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
    }

    val gotoComment = SingleLiveEvent<Any>()

    fun gotoComment() {
        gotoComment.call()
    }
}
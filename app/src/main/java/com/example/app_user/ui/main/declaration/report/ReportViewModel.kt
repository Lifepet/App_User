package com.example.app_user.ui.main.declaration.report

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.ReportModel
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReportViewModel(val app: Application) : AndroidViewModel(app) {
    val reportModel = MutableLiveData<ArrayList<ReportModel>>()
    val postId = MutableLiveData<String>()

    fun getReport(){
        Connecter.api.getReport(getToken(app.applicationContext)).enqueue(object : Callback<ArrayList<ReportModel>>{

            override fun onResponse(call: Call<ArrayList<ReportModel>>, response: Response<ArrayList<ReportModel>>) {
                reportModel.value=response.body()
            }

            override fun onFailure(call: Call<ArrayList<ReportModel>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}

package com.example.app_user.ui.main.review

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.AdoptListModel
import com.example.app_user.model.ReviewModel
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewViewModel(val app: Application) : AndroidViewModel(app) {

    val reviewModel = MutableLiveData<ArrayList<ReviewModel>>()
    val postId = MutableLiveData<String>()
    val gotoDetail = SingleLiveEvent<Any>()
    val gotoWrite=SingleLiveEvent<Any>()

    fun getReview() {
        Connecter.api.getReview(getToken(app.applicationContext)).enqueue(object : Callback<ArrayList<ReviewModel>> {
            override fun onResponse(
                call: Call<ArrayList<ReviewModel>>,
                response: Response<ArrayList<ReviewModel>>
            ) {
                when (response.code()) {
                    200 -> reviewModel.value = response.body()
                }
            }

            override fun onFailure(call: Call<ArrayList<ReviewModel>>, t: Throwable) {

            }
        })
    }

    fun adoptTouch(index: Int) {
        postId.value = reviewModel.value!![index].post_id
        gotoDetail.call()
    }

    fun writeReview(){
        gotoWrite.call()
    }
}

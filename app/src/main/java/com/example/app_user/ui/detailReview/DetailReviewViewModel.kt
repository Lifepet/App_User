package com.example.app_user.ui.detailReview

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.AdoptCommentModel
import com.example.app_user.model.AdoptListModel
import com.example.app_user.model.ReviewCommentModel
import com.example.app_user.model.ReviewModel
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailReviewViewModel(val app: Application) : AndroidViewModel(app) {
    val reviewModel = MutableLiveData<ReviewModel>()
    val postId = MutableLiveData<String>()
    val reviewCommentModel = MutableLiveData<ArrayList<ReviewCommentModel>>()

    fun getDetailReview() {
        Connecter.api.getReviewDetail(getToken(app.applicationContext), postId.value!!)
            .enqueue(object : Callback<ReviewModel> {
                override fun onResponse(call: Call<ReviewModel>, response: Response<ReviewModel>) {
                    reviewModel.value = response.body()
                }

                override fun onFailure(call: Call<ReviewModel>, t: Throwable) {

                }

            })
    }

    val gotoComment = SingleLiveEvent<Any>()

    fun gotoComment() {
        gotoComment.call()
    }

    fun getReviewComment() {
        Connecter.api.getReviewComment(getToken(app.applicationContext), postId.value!!)
            .enqueue(object : Callback<ArrayList<ReviewCommentModel>> {
                override fun onResponse(
                    call: Call<ArrayList<ReviewCommentModel>>,
                    response: Response<ArrayList<ReviewCommentModel>>
                ) {
                    reviewCommentModel.value = response.body()
                }

                override fun onFailure(call: Call<ArrayList<ReviewCommentModel>>, t: Throwable) {

                }
            })
    }
}
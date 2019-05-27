package com.example.app_user.ui.dialogComment

import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.view.Window
import android.widget.Toast
import com.example.app_user.R
import com.example.app_user.connecter.Connecter
import com.example.app_user.ui.writeLost.LostWriteViewModel
import com.example.app_user.util.DataBindingDialogFragment
import com.example.app_user.util.getToken
import kotlinx.android.synthetic.main.dialog_comment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentDialog(internal var context: Context) {

    var type: String = ""
    var postId: String = ""
    fun Comment() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_comment)
        dialog.show()
        dialog.bt_complete.setOnClickListener {
            when (type) {
                "입양" -> {
                    Connecter.api.postAdoptComment(
                        getToken(context),
                        postId,
                        hashMapOf("content" to dialog.edit_comment.text.toString())
                    ).enqueue(object : Callback<Unit> {

                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            if (response.code() == 201) {
                                dialog.dismiss()
                            }
                        }

                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                    })
                }

                "신고" -> {
                    Connecter.api.postLostComment(
                        getToken(context),
                        postId,
                        hashMapOf("content" to dialog.edit_comment.text.toString())
                    ).enqueue(object : Callback<Unit> {

                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            if (response.code() == 201) {
                                dialog.dismiss()
                            }
                        }

                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                    })

                }
                "제보" -> {
                    Connecter.api.postReportComment(
                        getToken(context),
                        postId,
                        hashMapOf("content" to dialog.edit_comment.text.toString())
                    ).enqueue(object : Callback<Unit> {

                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            if (response.code() == 201) {
                                dialog.dismiss()
                            }
                        }

                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                    })
                }
                "임시보호" -> {
                    Connecter.api.postProtectComment(
                        getToken(context),
                        postId,
                        hashMapOf("content" to dialog.edit_comment.text.toString())
                    ).enqueue(object : Callback<Unit> {

                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            if (response.code() == 201) {
                                dialog.dismiss()
                            }
                        }

                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                    })
                }
                "이동봉사" -> {
                    Connecter.api.postVolunteerComment(
                        getToken(context),
                        postId,
                        hashMapOf("content" to dialog.edit_comment.text.toString())
                    ).enqueue(object : Callback<Unit> {

                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            if (response.code() == 201) {
                                dialog.dismiss()
                            }
                        }

                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                    })
                }
                "후기" -> {
                    Connecter.api.postReviewComment(
                        getToken(context),
                        postId,
                        hashMapOf("content" to dialog.edit_comment.text.toString())
                    ).enqueue(object : Callback<Unit> {

                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            if (response.code() == 201) {
                                dialog.dismiss()
                            }
                        }

                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                    })
                }
            }
        }
    }
}

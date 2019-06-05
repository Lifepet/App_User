package com.example.app_user.ui.detailLost

import android.app.Dialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.Window
import com.example.app_user.R
import com.example.app_user.adapter.LostCommentAdapter
import com.example.app_user.connecter.Connecter
import com.example.app_user.databinding.ActivityDetailLostBinding
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.util.DataBindingActivity
import com.example.app_user.util.getToken
import kotlinx.android.synthetic.main.activity_detail_lost.*
import kotlinx.android.synthetic.main.dialog_comment.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailLostActivity : DataBindingActivity<ActivityDetailLostBinding>() {

    override val layoutId: Int get() = R.layout.activity_detail_lost

    private val viewModel: DetailLostViewModel by lazy {
        ViewModelProviders.of(this).get(DetailLostViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm=viewModel
        val intent=intent
        viewModel.postId.value=intent.getStringExtra("id")
        viewModel.getLostDetail()
        viewModel.getLostComment()
        viewModel.gotoComment.observe(this, Observer {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_comment)
            dialog.show()
            dialog.bt_complete.setOnClickListener {
                Connecter.api.postLostComment(
                    getToken(applicationContext),
                    viewModel.postId.value!!,
                    hashMapOf("content" to dialog.edit_comment.text.toString())
                ).enqueue(object : Callback<Unit> {

                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.code() == 201) {
                            dialog.dismiss()
                            toast("댓글작성이 완료되었습니다")
                            viewModel.getLostComment()
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
            }
        })
        lost_item_rv.adapter=LostCommentAdapter(viewModel)

        ic_back.setOnClickListener { startActivity<MainActivity>()
        finish()}

        handle.setOnClickListener { viewModel.getLostComment() }
    }
}
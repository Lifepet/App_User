package com.example.app_user.ui.detailReview

import android.app.Dialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.app_user.R
import com.example.app_user.adapter.ReviewCommentAdapter
import com.example.app_user.connecter.Connecter
import com.example.app_user.databinding.ActivityDetailReviewBinding
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.util.DataBindingActivity
import com.example.app_user.util.getToken
import kotlinx.android.synthetic.main.activity_detail_review.*
import kotlinx.android.synthetic.main.dialog_comment.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailReviewActivity : DataBindingActivity<ActivityDetailReviewBinding>() {

    override val layoutId: Int get() = R.layout.activity_detail_review

    private val viewModel: DetailReviewViewModel by lazy {
        ViewModelProviders.of(this).get(DetailReviewViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val intent = intent
        viewModel.postId.value = intent.getStringExtra("id")
        viewModel.getDetailReview()
        viewModel.getReviewComment()

        review_item_rv.adapter = ReviewCommentAdapter(viewModel)

        handle.setOnClickListener { viewModel.getReviewComment() }

        viewModel.gotoComment.observe(this, Observer {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_comment)
            dialog.show()
            dialog.bt_complete.setOnClickListener {
                Connecter.api.postReviewComment(
                    getToken(applicationContext),
                    viewModel.postId.value!!,
                    hashMapOf("content" to dialog.edit_comment.text.toString())
                ).enqueue(object : Callback<Unit> {

                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.code() == 201) {
                            toast("댓글작성이 완료되었습니다")
                            dialog.dismiss()
                            viewModel.getReviewComment()
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
            }
        })

        ic_back.setOnClickListener {
            startActivity<MainActivity>()
            finish()
        }
    }
}

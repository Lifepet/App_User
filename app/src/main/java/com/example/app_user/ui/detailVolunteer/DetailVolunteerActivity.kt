package com.example.app_user.ui.detailVolunteer

import android.app.Dialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.app_user.R
import com.example.app_user.adapter.VolunteerCommentAdapter
import com.example.app_user.connecter.Connecter
import com.example.app_user.databinding.ActivityDetailReviewBinding
import com.example.app_user.databinding.ActivityDetailVolunteerBinding
import com.example.app_user.ui.applyVolunteer.ApplyVolunteerActivity
import com.example.app_user.ui.detailReview.DetailReviewViewModel
import com.example.app_user.ui.dialogComment.CommentDialog
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.util.DataBindingActivity
import com.example.app_user.util.getToken
import kotlinx.android.synthetic.main.activity_detail_volunteer.*
import kotlinx.android.synthetic.main.dialog_comment.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailVolunteerActivity : DataBindingActivity<ActivityDetailVolunteerBinding>() {

    override val layoutId: Int get() = R.layout.activity_detail_volunteer

    private val viewModel: DetailVolunteerViewModel by lazy {
        ViewModelProviders.of(this).get(DetailVolunteerViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val intent = intent
        viewModel.postId.value = intent.getStringExtra("id")
        viewModel.getVolunteerDetail()
        viewModel.getVolunteerComment()

        volunteer_item_rv.adapter = VolunteerCommentAdapter(viewModel)

        viewModel.gotoApply.observe(
            this,
            Observer { startActivity<ApplyVolunteerActivity>("id" to viewModel.postId.value) })

        viewModel.gotoComment.observe(this, Observer {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_comment)
            dialog.show()
            dialog.bt_complete.setOnClickListener {
                Connecter.api.postVolunteerComment(
                    getToken(applicationContext),
                    viewModel.postId.value!!,
                    hashMapOf("content" to dialog.edit_comment.text.toString())
                ).enqueue(object : Callback<Unit> {

                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.code() == 201) {
                            toast("댓글작성이 완료되었습니다.")
                            dialog.dismiss()
                            viewModel.getVolunteerComment()
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
            }
        })

        handle.setOnClickListener { viewModel.getVolunteerComment() }

        ic_back.setOnClickListener {
            startActivity<MainActivity>()
            finish()
        }
    }
}

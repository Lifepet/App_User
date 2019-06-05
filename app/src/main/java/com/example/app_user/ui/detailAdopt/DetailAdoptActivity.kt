package com.example.app_user.ui.detailAdopt

import android.app.Dialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.example.app_user.R
import com.example.app_user.adapter.AdoptCommentAdapter
import com.example.app_user.connecter.Connecter
import com.example.app_user.databinding.ActivityDetailAdoptBinding
import com.example.app_user.ui.applyAdopt.ApplyAdoptActivity
import com.example.app_user.ui.dialogComment.CommentDialog
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.util.DataBindingActivity
import com.example.app_user.util.getToken
import kotlinx.android.synthetic.main.activity_detail_adopt.*
import kotlinx.android.synthetic.main.dialog_comment.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailAdoptActivity : DataBindingActivity<ActivityDetailAdoptBinding>() {

    override val layoutId: Int get() = R.layout.activity_detail_adopt

    private val viewModel: DetailAdoptViewModel by lazy {
        ViewModelProviders.of(this).get(DetailAdoptViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val intent = intent
        viewModel.postId.value = intent.getStringExtra("id")
        adopt_item_rv.adapter = AdoptCommentAdapter(viewModel)
        viewModel.getAdoptDetail()
        viewModel.getAdoptComment()
        viewModel.gotoApply.observe(
            this,
            Observer { startActivity<ApplyAdoptActivity>("id" to viewModel.postId.value) })

        viewModel.gotoComment.observe(this, Observer {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_comment)
            dialog.show()
            dialog.bt_complete.setOnClickListener {
                Connecter.api.postAdoptComment(
                    getToken(applicationContext),
                    viewModel.postId.value!!,
                    hashMapOf("content" to dialog.edit_comment.text.toString())
                ).enqueue(object : Callback<Unit> {

                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.code() == 201) {
                            dialog.dismiss()
                            viewModel.getAdoptComment()
                            toast("댓글작성이 완료되었습니다.")
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
            }
        })

        viewModel.getComment.observe(this, Observer { viewModel.getAdoptComment() })

        ic_back.setOnClickListener { viewModel.backMain.call() }


        viewModel.backMain.observe(this, Observer {
            startActivity<MainActivity>()
            finish()
        })
    }

    override fun onBackPressed() {

    }
}

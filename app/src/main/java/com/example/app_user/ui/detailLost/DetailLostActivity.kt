package com.example.app_user.ui.detailLost

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.adapter.LostCommentAdapter
import com.example.app_user.databinding.ActivityDetailLostBinding
import com.example.app_user.ui.dialogComment.CommentDialog
import com.example.app_user.util.DataBindingActivity
import kotlinx.android.synthetic.main.activity_detail_lost.*

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
            val dialog = CommentDialog(this)
            dialog.type = "신고"
            dialog.postId = viewModel.postId.value!!
            dialog.Comment()
        })
        lost_item_rv.adapter=LostCommentAdapter(viewModel)
    }
}
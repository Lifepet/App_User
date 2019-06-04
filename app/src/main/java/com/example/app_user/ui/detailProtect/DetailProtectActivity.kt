package com.example.app_user.ui.detailProtect

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.adapter.ProtectCommentAdapter
import com.example.app_user.databinding.ActivityDetailProtectBinding
import com.example.app_user.ui.applyProtect.ApplyProtectActivity
import com.example.app_user.ui.dialogComment.CommentDialog
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.util.DataBindingActivity
import kotlinx.android.synthetic.main.activity_detail_protect.*
import org.jetbrains.anko.startActivity

class DetailProtectActivity : DataBindingActivity<ActivityDetailProtectBinding>() {

    override val layoutId: Int get() = R.layout.activity_detail_protect

    private val viewModel: DetailProtectViewModel by lazy {
        ViewModelProviders.of(this).get(DetailProtectViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val intent = intent
        viewModel.postId.value = intent.getStringExtra("id")
        viewModel.getProtectDetail()
        viewModel.getProtectComment()
        viewModel.gotoApply.observe(
            this,
            Observer { startActivity<ApplyProtectActivity>("id" to viewModel.postId.value) })

        viewModel.gotoComment.observe(this, Observer {
            val dialog = CommentDialog(this)
            dialog.type = "임시보호"
            dialog.postId = viewModel.postId.value!!
            dialog.Comment()
        })
        handle.setOnClickListener { viewModel.getProtectComment() }
        protect_item_rv.adapter = ProtectCommentAdapter(viewModel)
        ic_back.setOnClickListener {
            startActivity<MainActivity>()
            finish()
        }
    }
}

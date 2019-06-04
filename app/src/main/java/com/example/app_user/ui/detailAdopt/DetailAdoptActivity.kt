package com.example.app_user.ui.detailAdopt

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.adapter.AdoptCommentAdapter
import com.example.app_user.databinding.ActivityDetailAdoptBinding
import com.example.app_user.ui.applyAdopt.ApplyAdoptActivity
import com.example.app_user.ui.dialogComment.CommentDialog
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.util.DataBindingActivity
import kotlinx.android.synthetic.main.activity_detail_adopt.*
import org.jetbrains.anko.startActivity

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
        viewModel.backMain.observe(this, Observer {
            startActivity<MainActivity>()
            finish()
        })
        viewModel.gotoApply.observe(
            this,
            Observer { startActivity<ApplyAdoptActivity>("id" to viewModel.postId.value) })

        viewModel.gotoComment.observe(this, Observer {
            val dialog = CommentDialog(this)
            dialog.type = "입양"
            dialog.postId = viewModel.postId.value!!
            dialog.Comment()
        })
        ic_back.setOnClickListener { viewModel.backMain.call() }
        handle.setOnClickListener { viewModel.getAdoptComment() }

        textView10.text = viewModel.type.value
    }
}

package com.example.app_user.ui.detailReport

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.databinding.ActivityDetailReportBinding
import com.example.app_user.ui.detailProtect.DetailProtectViewModel
import com.example.app_user.ui.dialogComment.CommentDialog
import com.example.app_user.util.DataBindingActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailReportActivity : DataBindingActivity<ActivityDetailReportBinding>() {

    override val layoutId: Int get() = R.layout.activity_detail_report

    private val viewModel: DetailReportViewModel by lazy {
        ViewModelProviders.of(this).get(DetailReportViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val intent = intent
        viewModel.postId.value = intent.getStringExtra("id")
        viewModel.getReportDetail()
    }
}

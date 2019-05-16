package com.example.app_user.ui.detailReview

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.databinding.ActivityDetailReviewBinding
import com.example.app_user.databinding.ActivityWriteReviewBinding
import com.example.app_user.ui.detailProtect.DetailProtectViewModel
import com.example.app_user.ui.dialogComment.CommentDialog
import com.example.app_user.ui.main.MainActivity
import com.example.app_user.ui.writeReview.WriteReviewViewModel
import com.example.app_user.util.DataBindingActivity
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.startActivity

class DetailReviewActivity : DataBindingActivity<ActivityDetailReviewBinding>() {

    override val layoutId: Int get() = R.layout.activity_detail_review

    private val viewModel: DetailReviewViewModel by lazy {
        ViewModelProviders.of(this).get(DetailReviewViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        val intent=intent
        viewModel.postId.value=intent.getStringExtra("id")
        viewModel.getDetailReview()
    }
}

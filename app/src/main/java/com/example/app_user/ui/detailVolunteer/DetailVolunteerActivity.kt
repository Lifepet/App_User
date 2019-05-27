package com.example.app_user.ui.detailVolunteer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.adapter.VolunteerCommentAdapter
import com.example.app_user.databinding.ActivityDetailReviewBinding
import com.example.app_user.databinding.ActivityDetailVolunteerBinding
import com.example.app_user.ui.applyVolunteer.ApplyVolunteerActivity
import com.example.app_user.ui.detailReview.DetailReviewViewModel
import com.example.app_user.ui.dialogComment.CommentDialog
import com.example.app_user.util.DataBindingActivity
import kotlinx.android.synthetic.main.activity_detail_volunteer.*
import org.jetbrains.anko.startActivity


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
            val dialog = CommentDialog(this)
            dialog.type = "이동봉사"
            dialog.postId = viewModel.postId.value!!
            dialog.Comment()
        })
    }
}

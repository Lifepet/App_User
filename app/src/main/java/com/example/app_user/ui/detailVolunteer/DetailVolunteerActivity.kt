package com.example.app_user.ui.detailVolunteer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.app_user.R
import com.example.app_user.databinding.ActivityDetailReviewBinding
import com.example.app_user.databinding.ActivityDetailVolunteerBinding
import com.example.app_user.ui.applyVolunteer.ApplyVolunteerActivity
import com.example.app_user.ui.detailReview.DetailReviewViewModel
import com.example.app_user.util.DataBindingActivity
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
        viewModel.gotoApply.observe(
            this,
            Observer { startActivity<ApplyVolunteerActivity>("id" to viewModel.postId.value) })
    }
}

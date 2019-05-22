package com.example.app_user.ui.main.review

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View

import com.example.app_user.R
import com.example.app_user.adapter.ReviewAdapter
import com.example.app_user.databinding.ReviewFragmentBinding
import com.example.app_user.ui.detailReview.DetailReviewActivity
import com.example.app_user.ui.writeReview.WriteReviewActivity
import com.example.app_user.util.DataBindingFragment
import kotlinx.android.synthetic.main.review_fragment.*
import org.jetbrains.anko.startActivity

class ReviewFragment : DataBindingFragment<ReviewFragmentBinding>() {
    override val layoutId: Int
        get() = R.layout.review_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!).get(ReviewViewModel::class.java)
        binding.vm = viewModel
        view_review.adapter=ReviewAdapter(viewModel)
        viewModel.getReview()
        viewModel.gotoDetail.observe(this, Observer { activity!!.startActivity<DetailReviewActivity>("id" to viewModel.postId.value.toString()) })
        viewModel.gotoWrite.observe(this, Observer { activity!!.startActivity<WriteReviewActivity>() })
    }

}

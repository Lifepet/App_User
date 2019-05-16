package com.example.app_user.ui.main.review

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.app_user.R
import com.example.app_user.adapter.AdoptAdapter
import com.example.app_user.adapter.ReviewAdapter
import com.example.app_user.databinding.ReviewFragmentBinding
import com.example.app_user.model.ReviewModel
import com.example.app_user.ui.detailReview.DetailReviewActivity
import com.example.app_user.ui.detail_adopt.DetailAdoptActivity
import com.example.app_user.ui.main.adopt.AdoptViewModel
import com.example.app_user.ui.writeReview.WriteReviewActivity
import com.example.app_user.util.DataBindingFragment
import com.example.app_user.util.RecyclerItemClickListener
import kotlinx.android.synthetic.main.adopt_fragment.*
import kotlinx.android.synthetic.main.review_fragment.*
import org.jetbrains.anko.find
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

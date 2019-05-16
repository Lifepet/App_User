package com.example.app_user.ui.main.review

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
import com.example.app_user.model.ReviewModel
import com.example.app_user.ui.detailReview.DetailReviewActivity
import com.example.app_user.ui.detail_adopt.DetailAdoptActivity
import com.example.app_user.ui.main.adopt.AdoptViewModel
import com.example.app_user.util.RecyclerItemClickListener
import kotlinx.android.synthetic.main.adopt_fragment.*
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class ReviewFragment : Fragment() {
//    override val layoutId: Int
//        get() = R.layout.adopt_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!).get(AdoptViewModel::class.java)
//        binding.vm = viewModel
//        view_adopt.adapter = AdoptAdapter(viewModel)
//        viewModel.getAdopt()
//        viewModel.gotoDetail.observe(
//            this,
//            Observer { activity!!.startActivity<DetailAdoptActivity>("id" to viewModel.postId.value.toString()) })
    }

}

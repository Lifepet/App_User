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
import com.example.app_user.adapter.ReviewAdapter
import com.example.app_user.model.ReviewModel
import com.example.app_user.ui.detail_review.DetailReviewActivity
import com.example.app_user.util.RecyclerItemClickListener
import org.jetbrains.anko.find

class ReviewFragment : Fragment() {

    companion object {
        fun newInstance() = ReviewFragment()
    }

    private lateinit var viewModel: ReviewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.review_fragment, container, false) as ViewGroup
        val recycler_review = layout.find<RecyclerView>(R.id.view_review)
        val reviewModel = ArrayList<ReviewModel>()
        recycler_review.setHasFixedSize(true)
        val adoptAdapter = ReviewAdapter(activity!!, reviewModel)
        recycler_review.layoutManager = LinearLayoutManager(context)
        recycler_review.adapter = adoptAdapter
        reviewModel.add(ReviewModel("사랑이 입양후기", "사랑이 입양후기랍니다", "류수영", "2019/4/15"))
        reviewModel.add(ReviewModel("사랑이 입양후기", "사랑이 입양후기랍니다", "류수영", "2019/4/15"))
        reviewModel.add(ReviewModel("사랑이 입양후기", "사랑이 입양후기랍니다", "류수영", "2019/4/15"))
        reviewModel.add(ReviewModel("사랑이 입양후기", "사랑이 입양후기랍니다", "류수영", "2019/4/15"))
        reviewModel.add(ReviewModel("사랑이 입양후기", "사랑이 입양후기랍니다", "류수영", "2019/4/15"))

        recycler_review.addOnItemTouchListener(
            RecyclerItemClickListener(context!!, recycler_review,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        startActivity(Intent(context, DetailReviewActivity::class.java))
                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                    }
                })
        )
        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ReviewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

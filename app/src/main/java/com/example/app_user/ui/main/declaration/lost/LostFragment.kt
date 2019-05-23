package com.example.app_user.ui.main.declaration.lost

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
import com.example.app_user.adapter.LostAdapter
import com.example.app_user.adapter.ReportAdapter
import com.example.app_user.databinding.LostFragmentBinding
import com.example.app_user.model.LostModel
import com.example.app_user.ui.detailLost.DetailLostActivity
import com.example.app_user.ui.main.declaration.report.ReportViewModel
import com.example.app_user.ui.writeLost.LostWriteActivity
import com.example.app_user.ui.writeLost.LostWriteViewModel
import com.example.app_user.util.DataBindingFragment
import com.example.app_user.util.RecyclerItemClickListener
import kotlinx.android.synthetic.main.declaration_fragment.*
import kotlinx.android.synthetic.main.lost_fragment.*
import kotlinx.android.synthetic.main.report_fragment.*
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class LostFragment : DataBindingFragment<LostFragmentBinding>() {

    override val layoutId: Int
        get() = R.layout.lost_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!).get(LostViewModel::class.java)
        binding.vm = viewModel
        view_lost.adapter = LostAdapter(viewModel)
        viewModel.getLost()
        viewModel.gotoDetail.observe(
            this,
            Observer { activity!!.startActivity<DetailLostActivity>("id" to viewModel.postId.value) })
        lost_write_fab.setOnClickListener { activity!!.startActivity<LostWriteActivity>() }
    }
}

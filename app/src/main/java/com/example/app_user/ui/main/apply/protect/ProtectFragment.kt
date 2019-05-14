package com.example.app_user.ui.main.apply.protect

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
import com.example.app_user.adapter.ProtectAdapter
import com.example.app_user.databinding.ProtectFragmentBinding
import com.example.app_user.model.ProtectModel
import com.example.app_user.ui.detailProtect.DetailProtectActivity
import com.example.app_user.ui.detail_adopt.DetailAdoptActivity
import com.example.app_user.ui.main.adopt.AdoptViewModel
import com.example.app_user.util.DataBindingFragment
import com.example.app_user.util.RecyclerItemClickListener
import kotlinx.android.synthetic.main.adopt_fragment.*
import kotlinx.android.synthetic.main.protect_fragment.*
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class ProtectFragment : DataBindingFragment<ProtectFragmentBinding>() {

    override val layoutId: Int
        get() = R.layout.protect_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!).get(ProtectViewModel::class.java)
        binding.vm = viewModel
        view_protect.adapter = ProtectAdapter(viewModel)
        viewModel.getProtect()
        viewModel.gotoDetail.observe(this, Observer { activity!!.startActivity<DetailProtectActivity>("id" to viewModel.postId.value!!) })
    }
}

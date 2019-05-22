package com.example.app_user.ui.main.apply.protect

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View

import com.example.app_user.R
import com.example.app_user.adapter.ProtectAdapter
import com.example.app_user.databinding.ProtectFragmentBinding
import com.example.app_user.ui.detailProtect.DetailProtectActivity
import com.example.app_user.util.DataBindingFragment
import kotlinx.android.synthetic.main.protect_fragment.*
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

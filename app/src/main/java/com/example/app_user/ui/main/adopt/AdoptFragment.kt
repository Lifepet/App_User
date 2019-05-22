package com.example.app_user.ui.main.adopt

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View

import com.example.app_user.R
import com.example.app_user.adapter.AdoptAdapter
import com.example.app_user.databinding.AdoptFragmentBinding
import com.example.app_user.ui.detailAdopt.DetailAdoptActivity
import com.example.app_user.util.DataBindingFragment
import kotlinx.android.synthetic.main.adopt_fragment.*
import org.jetbrains.anko.startActivity

class AdoptFragment : DataBindingFragment<AdoptFragmentBinding>() {

    override val layoutId: Int
        get() = R.layout.adopt_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!).get(AdoptViewModel::class.java)
        binding.vm = viewModel
        view_adopt.adapter = AdoptAdapter(viewModel)
        viewModel.getAdopt()
        viewModel.gotoDetail.observe(this, Observer { activity!!.startActivity<DetailAdoptActivity>("id" to viewModel.postId.value.toString() ) })
    }
}

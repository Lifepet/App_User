package com.example.app_user.ui.main.adopt

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.app_user.R
import com.example.app_user.adapter.AdoptAdapter
import com.example.app_user.databinding.AdoptFragmentBinding
import com.example.app_user.model.AdoptModel
import com.example.app_user.ui.detail_adopt.DetailAdoptActivity
import com.example.app_user.util.DataBindingFragment
import com.example.app_user.util.RecyclerItemClickListener
import com.example.app_user.util.getToken
import kotlinx.android.synthetic.main.adopt_fragment.*
import org.jetbrains.anko.find

class AdoptFragment : DataBindingFragment<AdoptFragmentBinding>() {

    override val layoutId: Int
        get() = R.layout.adopt_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!).get(AdoptViewModel::class.java)
        binding.vm = viewModel
        view_adopt.adapter=AdoptAdapter(viewModel)
    }


}

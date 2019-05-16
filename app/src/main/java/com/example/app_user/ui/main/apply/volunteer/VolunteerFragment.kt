package com.example.app_user.ui.main.apply.volunteer

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
import com.example.app_user.adapter.ProtectAdapter
import com.example.app_user.adapter.VolunteerAdapter
import com.example.app_user.databinding.VolunteerFragmentBinding
import com.example.app_user.model.VolunteerModel
import com.example.app_user.ui.detailProtect.DetailProtectActivity
import com.example.app_user.ui.detailVolunteer.DetailVolunteerActivity
import com.example.app_user.ui.main.apply.protect.ProtectViewModel
import com.example.app_user.util.DataBindingFragment
import com.example.app_user.util.RecyclerItemClickListener
import kotlinx.android.synthetic.main.protect_fragment.*
import kotlinx.android.synthetic.main.volunteer_fragment.*
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class VolunteerFragment : DataBindingFragment<VolunteerFragmentBinding>() {

    override val layoutId: Int
        get() = R.layout.volunteer_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!).get(VolunteerViewModel::class.java)
        binding.vm = viewModel
        view_volunteer.adapter = VolunteerAdapter(viewModel)
        viewModel.getVolunteer()
    }

}
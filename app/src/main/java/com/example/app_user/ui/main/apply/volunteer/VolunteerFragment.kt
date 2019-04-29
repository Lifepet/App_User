package com.example.app_user.ui.main.apply.volunteer

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.app_user.R

class VolunteerFragment : Fragment() {

    companion object {
        fun newInstance() = VolunteerFragment()
    }

    private lateinit var viewModel: VolunteerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.volunteer_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VolunteerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
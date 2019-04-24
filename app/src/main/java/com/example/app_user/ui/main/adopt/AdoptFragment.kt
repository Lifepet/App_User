package com.example.app_user.ui.main.adopt

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.app_user.R

class AdoptFragment : Fragment() {

    companion object {
        fun newInstance() = AdoptFragment()
    }

    private lateinit var viewModel: AdoptViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.adopt_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AdoptViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

package com.example.app_user.ui.main.declaration.lost

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.app_user.R

class LostFragment : Fragment() {

    companion object {
        fun newInstance() = LostFragment()
    }

    private lateinit var viewModel: LostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lost_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LostViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
